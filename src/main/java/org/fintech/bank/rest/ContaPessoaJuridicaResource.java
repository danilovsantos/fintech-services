package org.fintech.bank.rest;

import org.fintech.bank.dto.ContaPessoaJuridicaDTO;
import org.fintech.bank.service.ContaPessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class ContaPessoaJuridicaResource {

    @Autowired
    private ContaPessoaJuridicaService service;

    @PostMapping("/conta/pessoa-juridica")
    public ResponseEntity save(@Valid @RequestBody ContaPessoaJuridicaDTO pessoa){

        ContaPessoaJuridicaDTO contaDTO = this.service.cadastrarConta(pessoa);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contaDTO.getIdConta()).toUri();
        return ResponseEntity.created(location).body(contaDTO);
    }

}
