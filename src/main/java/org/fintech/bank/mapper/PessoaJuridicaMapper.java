package org.fintech.bank.mapper;

import org.fintech.bank.dto.PessoaJuridicaDTO;
import org.fintech.bank.entity.PessoaEntity;
import org.fintech.bank.entity.TipoPessoaEntity;
import org.fintech.bank.enums.TipoPessoaEnum;
import org.springframework.stereotype.Component;

/**
 * @author Danilo Valente
 * Classe responsável pela conversão entre DTO e Entity.
 */
@Component
public class PessoaJuridicaMapper {

    public PessoaEntity parseDtoToEntity(PessoaJuridicaDTO dto){

        PessoaEntity entity = new PessoaEntity();

        entity.setId(dto.getIdPessoa());
        entity.setCnpj(dto.getCNPJ());
        entity.setNomeFantasia(dto.getNomeFantasia());
        entity.setTipoPessoa(new TipoPessoaEntity(TipoPessoaEnum.PESSOA_FISICA.getValue()));

        return entity;
    }

    public PessoaJuridicaDTO parseEntityToDto(PessoaEntity entity){

        PessoaJuridicaDTO dto = new PessoaJuridicaDTO();

        dto.setIdPessoa(entity.getId());
        dto.setCNPJ(entity.getCnpj());
        dto.setNomeFantasia(entity.getNomeFantasia());
        dto.setRazaoSocial(entity.getRazaoSocial());

        return dto;
    }
}
