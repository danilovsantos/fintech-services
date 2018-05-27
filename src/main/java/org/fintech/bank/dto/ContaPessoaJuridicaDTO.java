package org.fintech.bank.dto;

import javax.validation.Valid;

public class ContaPessoaJuridicaDTO extends ContaPessoaDTO{

    @Valid
    private PessoaJuridicaDTO pessoaJuridica;

    public PessoaJuridicaDTO getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridicaDTO pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
}
