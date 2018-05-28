package org.fintech.bank.service;

import org.fintech.bank.dto.TransacaoFinanceiraDTO;
import org.fintech.bank.entity.ContaBancariaEntity;
import org.fintech.bank.entity.TipoTransacaoFinanceiraEntity;
import org.fintech.bank.entity.TransacaoFinanceiraEntity;
import org.fintech.bank.enums.StatusContaEnum;
import org.fintech.bank.enums.TipoContaEnum;
import org.fintech.bank.enums.TipoTransacaoFinEnum;
import org.fintech.bank.exception.*;
import org.fintech.bank.mapper.TransacaoFinanceiraMapper;
import org.fintech.bank.repository.ContaBancariaRepository;
import org.fintech.bank.repository.TipoTransacaoFinanceiraRepository;
import org.fintech.bank.repository.TransacaoFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Danilo Valente
 */

@Component
public class TransacaoFinanceiraService {

    @Autowired
    private ContaBancariaRepository contaBancRepository;

    @Autowired
    private TipoTransacaoFinanceiraRepository tipoTransFinRepository;

    @Autowired
    private TransacaoFinanceiraRepository transFinRepository;

    @Autowired
    private TransacaoFinanceiraMapper mapper;

    private TransacaoFinanceiraEntity transFinEntity;



    /**
     * Realiza transação financeira.
     * @param transacaoDTO
     */
    public TransacaoFinanceiraDTO realizarTransacao(TransacaoFinanceiraDTO transacaoDTO){
        this.popularEntidadeTransacao(transacaoDTO);
        this.validarEntidadeTransacao();
        this.prepararTransacao();
        this.transFinRepository.save(this.transFinEntity);
        return this.mapper.parseEntityToDto(this.transFinEntity);
    }



    /**
     * Prepara transacão
     * @return
     */
    private void prepararTransacao(){
        this.atualizarSaldoContaOrigem();
        this.atualizarSaldoContaDestino();
    }



    /**
     * Valida dados da transação.
     */
    private void validarEntidadeTransacao(){

        ContaBancariaEntity contaOrigem = this.transFinEntity.getContaOrigem();
        ContaBancariaEntity contaDestino = this.transFinEntity.getContaDestino();

        //TO-DO verificar se as contas de origem e destino pertencem a mesma árvore.


        //Verifica compatibilidade de transação entre tipo de contas.
        if(contaOrigem.getTipoContaBancaria().getId() == TipoContaEnum.FILIAL.getValue()
                && contaDestino.getTipoContaBancaria().getId() == TipoContaEnum.MATRIZ.getValue()){
            throw new TransacaoFinanceiraIncompativelException();
        }

        // Verifica se é uma transação entre contas matrizes e se o número do aporte foi informado.
        if(contaOrigem.getTipoContaBancaria().getId() == TipoContaEnum.MATRIZ.getValue()
                && contaDestino.getTipoContaBancaria().getId() == TipoContaEnum.MATRIZ.getValue()){
            if(this.transFinEntity.getCodigoAporte() == null
                    || this.transFinEntity.getCodigoAporte().trim().isEmpty()){
                throw new CodigoAporteNuloException();
            }
        }

        //Verifica se a conta destino está bloqueada.
        if(StatusContaEnum.BLOQUEADA.getValue() == contaDestino.getStatusContaBancaria().getId()){
            throw new ContaDestinoBloqueadaException();
        }

        //Verifica se a conta destino está cancelada.
        if(StatusContaEnum.CANCELADA.getValue() == contaDestino.getStatusContaBancaria().getId()){
            throw new ContaDestinoCanceladaException();
        }

        // veirifca se a conta origem possui saldo suficiente para transação.
        if(contaOrigem.getSaldo().doubleValue() < this.transFinEntity.getValor().doubleValue()){
            throw new SaldoInsuficienteException();
        }

    }



    /**
     * Realiza parse do DTO para Entidade
     * @param transacaoDTO
     */
    private void popularEntidadeTransacao(TransacaoFinanceiraDTO transacaoDTO){

        Optional<ContaBancariaEntity> contaOrigem = this.contaBancRepository.findById(transacaoDTO.getIdContaOrigem());
        Optional<ContaBancariaEntity> contaDestino = this.contaBancRepository.findById(transacaoDTO.getIdContaDestino());
        Optional<TipoTransacaoFinanceiraEntity> tipoTransacao = this.tipoTransFinRepository.findById(transacaoDTO.getIdTipoTransacao());

        this.transFinEntity = new TransacaoFinanceiraEntity();

        this.transFinEntity.setId(transacaoDTO.getIdTransacao());
        this.transFinEntity.setDataTransacao(LocalDate.now());
        this.transFinEntity.setCodigoAporte(transacaoDTO.getCodigoAporte());
        this.transFinEntity.setDescricao(transacaoDTO.getDescricao());
        this.transFinEntity.setValor(new BigDecimal(transacaoDTO.getValor().doubleValue()).setScale(2, RoundingMode.HALF_EVEN));

        // Verifica se a conta origem é válida.
        if(contaOrigem.isPresent()){
            this.transFinEntity.setContaOrigem(contaOrigem.get());
        } else {
            throw new ContaOrigemInvalidaException();
        }

        // Verifica se a conta destino é válida.
        if(contaDestino.isPresent()){
            this.transFinEntity.setContaDestino(contaDestino.get());
        }else {
            throw new ContaDestinoInvalidaException();
        }

        // Verifica se o tipo de transação financeira é válida.
        if(tipoTransacao.isPresent()){
            this.transFinEntity.setTipoTansacaoFinanceira(tipoTransacao.get());
        }else{
            throw new TipoTransacaoFinanceiraInvalidaException();
        }

    }

    /**
     * Atualiza saldo da conta origem.
     */
    private void atualizarSaldoContaOrigem(){
        BigDecimal valorTransacao = this.transFinEntity.getValor();
        ContaBancariaEntity contaOrigem = this.transFinEntity.getContaOrigem();
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valorTransacao));
    }

    /**
     * Atualiza saldo da conta destino.
     */
    private void atualizarSaldoContaDestino(){
        BigDecimal valorTransacao = this.transFinEntity.getValor();
        ContaBancariaEntity contaDestino = this.transFinEntity.getContaDestino();
        contaDestino.setSaldo(contaDestino.getSaldo().add(valorTransacao));
    }

    /**
     * Obtem lista com todas as transações.
     * @return List<TransacaoFinanceiraDTO>
     */
    public List<TransacaoFinanceiraDTO> getListaTransacaoFinanceira(){
        Iterable<TransacaoFinanceiraEntity> entities =  this.transFinRepository.findAll();
        List<TransacaoFinanceiraDTO> lista = new ArrayList<>();
        entities.forEach(ent -> lista.add(this.mapper.parseEntityToDto(ent)));
        return lista;
    }


}
