package org.fintech.bank.mapper;

import org.fintech.bank.dto.ContaPessoaJuridicaDTO;
import org.fintech.bank.dto.PessoaJuridicaDTO;
import org.fintech.bank.entity.ContaBancariaEntity;
import org.fintech.bank.entity.PessoaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class ContaPessoaJuridicaMapper {

    @Autowired
    private PessoaJuridicaMapper pessoaMapper;

    public ContaPessoaJuridicaDTO parseEntityToDto(ContaBancariaEntity entity){

        PessoaJuridicaDTO pessoaDTO = this.pessoaMapper.parseEntityToDto(entity.getPessoa());

        ContaPessoaJuridicaDTO contaDTO = new ContaPessoaJuridicaDTO();

        contaDTO.setSaldo(new BigDecimal(entity.getSaldo().doubleValue()).setScale(2, RoundingMode.HALF_EVEN));
        contaDTO.setIdConta(entity.getId());
        contaDTO.setDataCriacao(entity.getDataCriacao());
        contaDTO.setIdTipoConta(entity.getTipoContaEntity().getId());
        contaDTO.setIdStatusConta(entity.getStatusContaEntity().getId());
        contaDTO.setPessoaJuridica(pessoaDTO);

        if(entity.getContaBancariaPai() != null){
            contaDTO.setIdContaPai(entity.getContaBancariaPai().getId());
        }

        return contaDTO;
    }

    public ContaBancariaEntity parseDtoToEntity(ContaPessoaJuridicaDTO dto){

        PessoaEntity pessoaEntity = this.pessoaMapper.parseDtoToEntity(dto.getPessoaJuridica());

        ContaBancariaEntity entity = new ContaBancariaEntity();

        entity.setSaldo(new BigDecimal(dto.getSaldo().doubleValue()).setScale(2, RoundingMode.HALF_EVEN));
        entity.setId(dto.getIdConta());
        entity.setDataCriacao(dto.getDataCriacao());
        entity.setPessoa(pessoaEntity);

        return entity;
    }

}
