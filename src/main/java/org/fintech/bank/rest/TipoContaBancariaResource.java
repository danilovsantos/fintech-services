package org.fintech.bank.rest;

import org.fintech.bank.dto.TipoContaBancariaDTO;
import org.fintech.bank.service.TipoContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/*import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoContaBancariaResource {

    @Autowired
    private TipoContaBancariaService service;

    @PostMapping("/tipo-conta-bancaria")
    public ResponseEntity save(@RequestBody TipoContaBancariaDTO tipoContaBancariaDTO){

        TipoContaBancariaDTO dto = this.service.cadastrarTipoContaBancaria(tipoContaBancariaDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("/tipo-conta-bancaria")
    public ResponseEntity getAll(){
        List<TipoContaBancariaDTO> lista = this.service.getListaTipoContaBancaria();
        return ResponseEntity.accepted().body(lista);
    }

}*/
