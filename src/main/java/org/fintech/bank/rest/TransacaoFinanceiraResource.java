package org.fintech.bank.rest;

import org.fintech.bank.dto.TransacaoFinanceiraDTO;
import org.fintech.bank.service.TransacaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransacaoFinanceiraResource {


    @Autowired
    private TransacaoFinanceiraService service;


    @GetMapping("/transacao-financeira")
    public ResponseEntity getAll(){
        List<TransacaoFinanceiraDTO> lista = this.service.getListaTransacaoFinanceira();
        return ResponseEntity.accepted().body(lista);
    }

    @PostMapping("/transacao-financeira")
    public void save(@RequestBody TransacaoFinanceiraDTO dto){
        this.service.realizarTransacao(dto);
    }

}
