package org.fintech.bank.service;

import org.fintech.bank.dto.TipoPessoaDTO;
import org.fintech.bank.entity.TipoPessoaEntity;
import org.fintech.bank.repository.TipoPessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Danilo Valente
 */
@Component
public class TipoPessoaService {

    @Autowired
    private TipoPessoaRepository repository;

    public TipoPessoaDTO cadastrarTipoPessoa(TipoPessoaDTO tipoPessoaDTO){
        ModelMapper modelMapper = new ModelMapper();
        TipoPessoaEntity tipoPessoaEntity = modelMapper.map(tipoPessoaDTO, TipoPessoaEntity.class);
        this.repository.save(tipoPessoaEntity);
        return modelMapper.map(tipoPessoaEntity, TipoPessoaDTO.class);
    }

    public List<TipoPessoaDTO> getListaTipoPessoa(){
        Iterable<TipoPessoaEntity> entities =  this.repository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entities, ArrayList.class);
    }

}
