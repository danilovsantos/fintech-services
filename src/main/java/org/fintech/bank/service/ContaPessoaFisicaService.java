package org.fintech.bank.service;

import org.fintech.bank.dto.ContaPessoaFisicaDTO;
import org.fintech.bank.entity.ContaBancariaEntity;
import org.fintech.bank.entity.PessoaEntity;
import org.fintech.bank.exception.ContaPaiNaoLocalizadaException;
import org.fintech.bank.exception.StatusContaInvalidoException;
import org.fintech.bank.exception.TipoContaInvalidoException;
import org.fintech.bank.mapper.ContaPessoaFisicaMapper;
import org.fintech.bank.mapper.PessoaFisicaMapper;
import org.fintech.bank.repository.ContaBancariaRepository;
import org.fintech.bank.repository.StatusContaBancariaRepository;
import org.fintech.bank.repository.TipoContaBancariaRepository;
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
    private PessoaFisicaMapper pessoaMapper;

    @Autowired
    private ContaPessoaFisicaMapper contaPessoaFisicaMapper;

    private ContaBancariaEntity contaBancariaEntity;


    /**
     * Cadastra conta (Física ou Jurídica)
     * @param contaPessoaFisicaDto
     * @return
     */
    public ContaPessoaFisicaDTO cadastrarContaBancaria(ContaPessoaFisicaDTO contaPessoaFisicaDto) {
        this.populaContaBancariaEntity(contaPessoaFisicaDto);
        this.contaBancariaRepository.save(this.contaBancariaEntity);
        return this.contaPessoaFisicaMapper.parseEntityToDto(this.contaBancariaEntity);

    }


    /**
     * Popula e completa instância de entidade Conta bancária com os dados do DTO.
     * @param contaPessoaFisicaDto
     */
    private void populaContaBancariaEntity(ContaPessoaFisicaDTO contaPessoaFisicaDto){

        //Faz conversão do DTO para Entidade
        this.contaBancariaEntity = this.contaPessoaFisicaMapper.parseDtoToEntity(contaPessoaFisicaDto);

        this.contaBancariaEntity.setDataCriacao(LocalDate.now());

        // Seta conta bancária pai

        if(contaPessoaFisicaDto.getIdContaPai() != null){
            if(!this.contaBancariaRepository.existsById(contaPessoaFisicaDto.getIdContaPai())){
                throw new ContaPaiNaoLocalizadaException(contaPessoaFisicaDto.getIdContaPai());
            }
            this.contaBancariaEntity.setContaBancariaPai(this.contaBancariaRepository.findById(contaPessoaFisicaDto.getIdContaPai()).get());
        }


        // Seta tipo de conta. (Matriz ou Filial)

        if(contaPessoaFisicaDto.getIdTipoConta() != null){
            if(!this.tipoContaBancariaRepository.existsById(contaPessoaFisicaDto.getIdTipoConta())){
                throw new TipoContaInvalidoException(contaPessoaFisicaDto.getIdTipoConta());
            }
            this.contaBancariaEntity.setTipoContaEntity(this.tipoContaBancariaRepository.findById(contaPessoaFisicaDto.getIdTipoConta()).get());
        }


        // Seta status da conta. (Ativa, Bloquada ou Cancelada)

        if(contaPessoaFisicaDto.getIdStatusConta() != null){
            if(!this.statusContaBancariaRepository.existsById(contaPessoaFisicaDto.getIdStatusConta())){
                throw new StatusContaInvalidoException(contaPessoaFisicaDto.getIdStatusConta());
            }
            this.contaBancariaEntity.setStatusContaEntity(this.statusContaBancariaRepository.findById(contaPessoaFisicaDto.getIdStatusConta()).get());
        }

    }


}
