package org.fintech.bank.rest;

import org.fintech.bank.dto.TransacaoFinanceiraDTO;
import org.fintech.bank.service.EstornoFinanceiroService;
import org.fintech.bank.service.TransacaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        this.service.realizarTransacao(dto);
        return ResponseEntity.accepted().body("");
    }

    @GetMapping("/transacao-financeira-estorno/{idTransacao}")
    public ResponseEntity estorno(@PathVariable Long idTransacao){
        this.estornoService.realizarEstorno(idTransacao);
        return ResponseEntity.accepted().body("Estorno de transação realizado com sucesso!");
    }

}
