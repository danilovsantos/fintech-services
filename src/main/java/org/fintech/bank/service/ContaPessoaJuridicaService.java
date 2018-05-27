package org.fintech.bank.service;

import org.fintech.bank.dto.ContaPessoaJuridicaDTO;
import org.fintech.bank.entity.ContaBancariaEntity;
import org.fintech.bank.exception.ContaPaiInvalidaException;
import org.fintech.bank.exception.StatusContaInvalidoException;
import org.fintech.bank.exception.TipoContaInvalidoException;
import org.fintech.bank.mapper.ContaPessoaJuridicaMapper;
import org.fintech.bank.repository.ContaBancariaRepository;
import org.fintech.bank.repository.StatusContaBancariaRepository;
import org.fintech.bank.repository.TipoContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ContaPessoaJuridicaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    @Autowired
    private TipoContaBancariaRepository tipoContaBancariaRepository;

    @Autowired
    private StatusContaBancariaRepository statusContaBancariaRepository;

    @Autowired
    private ContaPessoaJuridicaMapper contaPessoaJuridicaMapper;

    private ContaBancariaEntity contaBancariaEntity;

    /**
     * Cadastra conta (Física ou Jurídica)
     * @param contaPessoaJuridicaDTO
     * @return
     */
    public ContaPessoaJuridicaDTO cadastrarConta(ContaPessoaJuridicaDTO contaPessoaJuridicaDTO) {
        this.populaContaBancariaEntity(contaPessoaJuridicaDTO);
        this.contaBancariaRepository.save(this.contaBancariaEntity);
        return this.contaPessoaJuridicaMapper.parseEntityToDto(this.contaBancariaEntity);

    }


    /**
     * Popula e completa instância de entidade Conta bancária com os dados do DTO.
     * @param contaPessoaJuridicaDTO
     */
    private void populaContaBancariaEntity(ContaPessoaJuridicaDTO contaPessoaJuridicaDTO){

        //Faz conversão do DTO para Entidade
        this.contaBancariaEntity = this.contaPessoaJuridicaMapper.parseDtoToEntity(contaPessoaJuridicaDTO);

        this.contaBancariaEntity.setDataCriacao(LocalDate.now());

        // Seta conta bancária pai

        if(contaPessoaJuridicaDTO.getIdContaPai() != null){
            if(!this.contaBancariaRepository.existsById(contaPessoaJuridicaDTO.getIdContaPai())){
                throw new ContaPaiInvalidaException();
            }
            this.contaBancariaEntity.setContaBancariaPai(this.contaBancariaRepository.findById(contaPessoaJuridicaDTO.getIdContaPai()).get());
        }


        // Seta tipo de conta. (Matriz ou Filial)

        if(contaPessoaJuridicaDTO.getIdTipoConta() != null){
            if(!this.tipoContaBancariaRepository.existsById(contaPessoaJuridicaDTO.getIdTipoConta())){
                throw new TipoContaInvalidoException();
            }
            this.contaBancariaEntity.setTipoContaBancaria(this.tipoContaBancariaRepository.findById(contaPessoaJuridicaDTO.getIdTipoConta()).get());
        }


        // Seta status da conta. (Ativa, Bloquada ou Cancelada)

        if(contaPessoaJuridicaDTO.getIdStatusConta() != null){
            if(!this.statusContaBancariaRepository.existsById(contaPessoaJuridicaDTO.getIdStatusConta())){
                throw new StatusContaInvalidoException();
            }
            this.contaBancariaEntity.setStatusContaBancaria(this.statusContaBancariaRepository.findById(contaPessoaJuridicaDTO.getIdStatusConta()).get());
        }

    }

}
