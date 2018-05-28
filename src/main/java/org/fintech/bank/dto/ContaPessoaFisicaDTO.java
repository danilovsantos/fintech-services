package org.fintech.bank.dto;

import javax.validation.Valid;

/**
 * @author Danilo Valente
 */

public class ContaPessoaFisicaDTO extends  ContaPessoaDTO{

    @Valid
    private PessoaFisicaDTO pessoaFisica;

    public PessoaFisicaDTO getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisicaDTO pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}
