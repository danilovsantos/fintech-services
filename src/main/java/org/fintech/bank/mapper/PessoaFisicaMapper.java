package org.fintech.bank.mapper;

import org.fintech.bank.dto.PessoaFisicaDTO;
import org.fintech.bank.entity.PessoaEntity;
import org.fintech.bank.entity.TipoPessoaEntity;
import org.fintech.bank.enums.TipoPessoaEnum;
import org.springframework.stereotype.Component;

@Component
public class PessoaFisicaMapper {

    public PessoaEntity parseDtoToEntity(PessoaFisicaDTO dto){

        PessoaEntity pessoa = new PessoaEntity();

        pessoa.setId(dto.getIdPessoa());
        pessoa.setCpf(dto.getCpf());
        pessoa.setDataNascimento(dto.getDataNascimento());
        pessoa.setNome(dto.getNome());
        pessoa.setTipoPessoa(new TipoPessoaEntity(TipoPessoaEnum.PESSOA_FISICA.getValue()));

        return pessoa;
    }

    public PessoaFisicaDTO parseEntityToDto(PessoaEntity entity){

        PessoaFisicaDTO dto = new PessoaFisicaDTO();

        dto.setCpf(entity.getCpf());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setIdPessoa(entity.getId());
        dto.setNome(entity.getNome());

        return dto;
    }

}
