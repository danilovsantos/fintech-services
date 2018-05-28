package org.fintech.bank.rest;

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
