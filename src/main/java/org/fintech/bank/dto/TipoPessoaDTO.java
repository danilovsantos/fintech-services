package org.fintech.bank.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TipoPessoaDTO {

    private Long id;

    @NotNull
    @Size(min=1, max = 45, message = "Descrição deve ter tamanho entre 1 e 45 caracteres.")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
