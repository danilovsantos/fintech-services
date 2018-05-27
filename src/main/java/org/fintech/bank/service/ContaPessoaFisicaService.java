package org.fintech.bank.service;

import org.fintech.bank.dto.ContaPessoaFisicaDTO;
import org.fintech.bank.entity.ContaBancariaEntity;
import org.fintech.bank.enums.TipoContaEnum;
import org.fintech.bank.exception.*;
import org.fintech.bank.mapper.ContaPessoaFisicaMapper;
import org.fintech.bank.mapper.PessoaFisicaMapper;
import org.fintech.bank.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ContaPessoaFisicaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    @Autowired
    private TipoContaBancariaRepository tipoContaBancariaRepository;

    @Autowired
    private StatusContaBancariaRepository statusContaBancariaRepository;

    @Autowired
    private TipoPessoaRepository tipoPessoaRepository;

    @Autowired
    private ContaPessoaFisicaMapper contaPessoaFisicaMapper;

    private ContaBancariaEntity contaBancariaEntity;


    /**
     * Cadastra conta (Física ou Jurídica)
     * @param contaPessoaFisicaDto
     * @return ContaPessoaFisicaDTO
     */
    public ContaPessoaFisicaDTO cadastrarContaBancaria(ContaPessoaFisicaDTO contaPessoaFisicaDto) {
        this.popularEntidadeContaBancaria(contaPessoaFisicaDto);
        this.validarEntidadeContaBancaria();
        this.contaBancariaRepository.save(this.contaBancariaEntity);
        return this.contaPessoaFisicaMapper.parseEntityToDto(this.contaBancariaEntity);
    }


    /**
     * Popula e completa instância de entidade Conta bancária com os dados do DTO.
     * @param contaPessoaFisicaDto
     */
    private void popularEntidadeContaBancaria(ContaPessoaFisicaDTO contaPessoaFisicaDto){

        //Faz conversão do DTO para Entidade

        this.contaBancariaEntity = this.contaPessoaFisicaMapper.parseDtoToEntity(contaPessoaFisicaDto);

        this.contaBancariaEntity.setDataCriacao(LocalDate.now());

        // Seta conta bancária pai

        if(contaPessoaFisicaDto.getIdContaPai() != null){
            if(!this.contaBancariaRepository.existsById(contaPessoaFisicaDto.getIdContaPai())){
                throw new ContaPaiInvalidaException();
            }
            this.contaBancariaEntity.setContaBancariaPai(this.contaBancariaRepository.findById(contaPessoaFisicaDto.getIdContaPai()).get());
        }


        // Seta tipo de conta. (Matriz ou Filial)

        if(contaPessoaFisicaDto.getIdTipoConta() != null){
            if(!this.tipoContaBancariaRepository.existsById(contaPessoaFisicaDto.getIdTipoConta())){
                throw new TipoContaInvalidoException();
            }
            this.contaBancariaEntity.setTipoContaBancaria(this.tipoContaBancariaRepository.findById(contaPessoaFisicaDto.getIdTipoConta()).get());
        }


        // Seta status da conta. (Ativa, Bloquada ou Cancelada)

        if(contaPessoaFisicaDto.getIdStatusConta() != null){
            if(!this.statusContaBancariaRepository.existsById(contaPessoaFisicaDto.getIdStatusConta())){
                throw new StatusContaInvalidoException();
            }
            this.contaBancariaEntity.setStatusContaBancaria(this.statusContaBancariaRepository.findById(contaPessoaFisicaDto.getIdStatusConta()).get());
        }

        if(contaPessoaFisicaDto.getPessoaFisica().getIdTipoPessoa() != null){
            if(!this.tipoPessoaRepository.existsById(contaPessoaFisicaDto.getPessoaFisica().getIdTipoPessoa())){
                throw new TipoPessoaInvalidoException();
            }
            this.contaBancariaEntity.getPessoa().setTipoPessoa(this.tipoPessoaRepository.findById(contaPessoaFisicaDto.getPessoaFisica().getIdTipoPessoa()).get());
        }

    }


    private void validarEntidadeContaBancaria(){
        if(this.contaBancariaEntity.getTipoContaBancaria().getId() == TipoContaEnum.FILIAL.getValue()){
            if(this.contaBancariaEntity.getContaBancariaPai() == null){
                throw new ContaFilialSemPaiException();
            }
        }
    }


}
