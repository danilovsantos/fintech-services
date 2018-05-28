package org.fintech.bank.enums;

/**
 * @author Danilo Valente
 */

public enum TipoPessoaEnum {

    PESSOA_FISICA(1L),
    PESSOA_JURIDICA(2L);

    private Long value;

    TipoPessoaEnum(Long value){
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

}
