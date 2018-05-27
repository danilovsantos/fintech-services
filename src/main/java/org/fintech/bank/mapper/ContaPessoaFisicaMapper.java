package org.fintech.bank.mapper;

import org.fintech.bank.dto.ContaPessoaFisicaDTO;
import org.fintech.bank.dto.PessoaFisicaDTO;
import org.fintech.bank.entity.ContaBancariaEntity;
import org.fintech.bank.entity.PessoaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class ContaPessoaFisicaMapper {

    @Autowired
    private PessoaFisicaMapper pessoaMapper;

    public ContaPessoaFisicaDTO parseEntityToDto(ContaBancariaEntity entity){

        PessoaFisicaDTO pessoaDto = this.pessoaMapper.parseEntityToDto(entity.getPessoa());

        ContaPessoaFisicaDTO dto = new ContaPessoaFisicaDTO();

        dto.setSaldo(new BigDecimal(entity.getSaldo().doubleValue()).setScale(2, RoundingMode.HALF_EVEN));
        dto.setIdConta(entity.getId());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setIdTipoConta(entity.getTipoContaEntity().getId());
        dto.setIdStatusConta(entity.getStatusContaEntity().getId());
        dto.setPessoaFisica(pessoaDto);

        if(entity.getContaBancariaPai() != null){
            dto.setIdContaPai(entity.getContaBancariaPai().getId());
        }

        return dto;
    }

    public ContaBancariaEntity parseDtoToEntity(ContaPessoaFisicaDTO dto){

        PessoaEntity pessoaEntity = this.pessoaMapper.parseDtoToEntity(dto.getPessoaFisica());

        ContaBancariaEntity contaEntity = new ContaBancariaEntity();

        contaEntity.setSaldo(new BigDecimal(dto.getSaldo().doubleValue()).setScale(2, RoundingMode.HALF_EVEN));
        contaEntity.setId(dto.getIdConta());
        contaEntity.setDataCriacao(dto.getDataCriacao());
        contaEntity.setPessoa(pessoaEntity);

        return contaEntity;
    }

}
