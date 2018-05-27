package org.fintech.bank.service;

import org.fintech.bank.dto.TipoContaBancariaDTO;
import org.fintech.bank.entity.TipoContaBancariaEntity;
import org.fintech.bank.repository.TipoContaBancariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TipoContaBancariaService {

    @Autowired
    private TipoContaBancariaRepository repository;

    public TipoContaBancariaDTO cadastrarTipoContaBancaria(TipoContaBancariaDTO tipoContaBancariaDTO){
        ModelMapper modelMapper = new ModelMapper();
        TipoContaBancariaEntity tipoContaBancariaEntity = modelMapper.map(tipoContaBancariaDTO, TipoContaBancariaEntity.class);
        this.repository.save(tipoContaBancariaEntity);
        return modelMapper.map(tipoContaBancariaEntity, TipoContaBancariaDTO.class);
    }

    public List<TipoContaBancariaDTO> getListaTipoContaBancaria(){
        Iterable<TipoContaBancariaEntity> entities =  this.repository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entities, ArrayList.class);
    }


}
