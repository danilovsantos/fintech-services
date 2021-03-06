package org.fintech.bank.enums;

/**
 * @author Danilo Valente
 */

public enum StatusContaEnum {

    ATIVA(1L),
    BLOQUEADA(2L),
    CANCELADA(3L);

    private Long value;

    StatusContaEnum(Long value){
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
