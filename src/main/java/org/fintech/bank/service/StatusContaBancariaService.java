package org.fintech.bank.service;

import org.fintech.bank.dto.StatusContaBancariaDTO;
import org.fintech.bank.entity.StatusContaBancariaEntity;
import org.fintech.bank.repository.StatusContaBancariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Danilo Valente
 */
@Component
public class StatusContaBancariaService {

    @Autowired
    private StatusContaBancariaRepository repository;

    public StatusContaBancariaDTO cadastrarStatusContaBancaria(StatusContaBancariaDTO statusContaBancariaDTO){
        ModelMapper modelMapper = new ModelMapper();
        StatusContaBancariaEntity statusContaBancariaEntity = modelMapper.map(statusContaBancariaDTO, StatusContaBancariaEntity.class);
        this.repository.save(statusContaBancariaEntity);
        return modelMapper.map(statusContaBancariaEntity, StatusContaBancariaDTO.class);
    }

    public List<StatusContaBancariaDTO> getListaStatusContaBancaria(){
        Iterable<StatusContaBancariaEntity> entities =  this.repository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entities, ArrayList.class);
    }

}
