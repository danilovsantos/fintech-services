/*package org.fintech.bank.rest;

import org.fintech.bank.dto.TipoPessoaDTO;
import org.fintech.bank.service.TipoPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoPessoaResource {

    @Autowired
    private TipoPessoaService service;

    @PostMapping("/tipo-pessoa")
    public ResponseEntity save(@RequestBody TipoPessoaDTO tipoPessoaDTO){

        TipoPessoaDTO dto = this.service.cadastrarTipoPessoa(tipoPessoaDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("/tipo-pessoa")
    public ResponseEntity getAll(){
        List<TipoPessoaDTO> lista = this.service.getListaTipoPessoa();
        return ResponseEntity.accepted().body(lista);
    }

}*/
