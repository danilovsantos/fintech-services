package org.fintech.bank.rest;

import org.fintech.bank.dto.ContaPessoaFisicaDTO;
import org.fintech.bank.service.ContaPessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * @author Danilo Valente
 */

@RestController
@RequestMapping("/api")
public class ContaPessoaFisicaResource {

    @Autowired
    private ContaPessoaFisicaService service;

    @PostMapping("/conta/pessoa-fisica")
    public ResponseEntity save(@Valid  @RequestBody ContaPessoaFisicaDTO conta)  {

        ContaPessoaFisicaDTO contaDTO = this.service.cadastrarContaBancaria(conta);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contaDTO.getIdConta()).toUri();

        return ResponseEntity.created(location).body(contaDTO);
    }

}
