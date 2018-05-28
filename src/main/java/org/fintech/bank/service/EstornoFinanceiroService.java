package org.fintech.bank.service;

import org.fintech.bank.entity.ContaBancariaEntity;
import org.fintech.bank.entity.TipoTransacaoFinanceiraEntity;
import org.fintech.bank.entity.TransacaoFinanceiraEntity;
import org.fintech.bank.enums.StatusContaEnum;
import org.fintech.bank.enums.TipoTransacaoFinEnum;
import org.fintech.bank.exception.*;
import org.fintech.bank.repository.TransacaoFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EstornoFinanceiroService {

    @Autowired
    private TransacaoFinanceiraRepository transFinRepository;

    private TransacaoFinanceiraEntity transFinEntity;
    private TransacaoFinanceiraEntity transacaoAnterior;



    /**
     * Realiza estorno de valores.
     * @param idTransacao
     */
    public void realizarEstorno(Long idTransacao){
        this.prepararTransacao(idTransacao);
        this.validarEntidadeTransacao();
        this.transFinRepository.save(this.transFinEntity);

    }



    /**
     * Prepara objeto de transacção financeira.
     * @param idTransacao
     */
    private void prepararTransacao(Long idTransacao){

        Optional<TransacaoFinanceiraEntity> transacaoAnterior = this.transFinRepository.findById(idTransacao);

        if(!transacaoAnterior.isPresent()){
            throw new TransacaoFinanceiraInvalidaException();
        }

        this.transacaoAnterior = transacaoAnterior.get();

        ContaBancariaEntity contaOrigem = transacaoAnterior.get().getContaOrigem();
        ContaBancariaEntity contaDestino = transacaoAnterior.get().getContaDestino();

        //Estorna valor da conta destino e deposita na conta origem.
        contaOrigem.setSaldo(contaOrigem.getSaldo().add(transacaoAnterior.get().getValor()));
        contaDestino.setSaldo(contaDestino.getSaldo().subtract(transacaoAnterior.get().getValor()));

        this.transFinEntity = new TransacaoFinanceiraEntity();

        this.transFinEntity.setValor(transacaoAnterior.get().getValor());
        this.transFinEntity.setContaOrigem(transacaoAnterior.get().getContaDestino());
        this.transFinEntity.setContaDestino(transacaoAnterior.get().getContaOrigem());
        this.transFinEntity.setDescricao(transacaoAnterior.get().getDescricao());
        this.transFinEntity.setTipoTansacaoFinanceira(new TipoTransacaoFinanceiraEntity(TipoTransacaoFinEnum.ESTORNO.getValue()));

    }



    /**
     * Valida objeto de transação financeira.
     */

    private void validarEntidadeTransacao(){

        //Verifica se a conta destino está bloqueada.
        if(StatusContaEnum.BLOQUEADA.getValue() == transFinEntity.getContaDestino().getStatusContaBancaria().getId()){
            throw new ContaDestinoBloqueadaException();
        }

        //Verifica se a conta destino está cancelada.
        if(StatusContaEnum.CANCELADA.getValue() == transFinEntity.getContaDestino().getStatusContaBancaria().getId()){
            throw new ContaDestinoCanceladaException();
        }

        //Verifica se a conta origem está bloqueada.
        if(StatusContaEnum.BLOQUEADA.getValue() == transFinEntity.getContaOrigem().getStatusContaBancaria().getId()){
            throw new ContaOrigemBloqueadaException();
        }

        //Verifica se a conta origem está cancelada.
        if(StatusContaEnum.CANCELADA.getValue() == transFinEntity.getContaOrigem().getStatusContaBancaria().getId()){
            throw new ContaOrigemCanceladaException();
        }

        // Verifica se a conta possui saldo suficiente para realizar estorno.
        if(transFinEntity.getContaDestino().getSaldo().doubleValue() < transFinEntity.getValor().doubleValue()){
            throw new SaldoInsuficienteEstornoException();
        }

    }

}
