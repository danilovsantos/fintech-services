/*package org.fintech.bank.rest;

import org.fintech.bank.dto.StatusContaBancariaDTO;
import org.fintech.bank.service.StatusContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusContaBancariaResource {

    @Autowired
    private StatusContaBancariaService service;

    @PostMapping("/status-conta-bancaria")
    public ResponseEntity save(@RequestBody StatusContaBancariaDTO statusContaBancariaDTO){

        StatusContaBancariaDTO dto = this.service.cadastrarStatusContaBancaria(statusContaBancariaDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("/status-conta-bancaria")
    public ResponseEntity getAll(){
        List<StatusContaBancariaDTO> lista = this.service.getListaStatusContaBancaria();
        return ResponseEntity.accepted().body(lista);
    }

}*/
