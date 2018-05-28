package org.fintech.bank.rest;

import org.fintech.bank.dto.TransacaoFinanceiraDTO;
import org.fintech.bank.service.EstornoFinanceiroService;
import org.fintech.bank.service.TransacaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
/**
 * @author Danilo Valente
 */
@RestController
@RequestMapping("/api")
public class TransacaoFinanceiraResource {


    @Autowired
    private TransacaoFinanceiraService service;

    @Autowired
    private EstornoFinanceiroService estornoService;


    @GetMapping("/transacao-financeira")
    public ResponseEntity getAll(){
        List<TransacaoFinanceiraDTO> lista = this.service.getListaTransacaoFinanceira();
        return ResponseEntity.accepted().body(lista);
    }

    @PostMapping("/transacao-financeira")
    public ResponseEntity save(@RequestBody TransacaoFinanceiraDTO dto){
        TransacaoFinanceiraDTO transacao = this.service.realizarTransacao(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(transacao.getIdTransacao()).toUri();
        return ResponseEntity.created(location).body(transacao);
    }

    @GetMapping("/transacao-financeira-estorno/{idTransacao}")
    public ResponseEntity estorno(@PathVariable Long idTransacao){
        this.estornoService.realizarEstorno(idTransacao);
        return ResponseEntity.accepted().body("Estorno de transação realizado com sucesso!");
    }

}
