package org.fintech.bank.enums;

/**
 * @author Danilo Valente
 */

public enum TipoContaEnum {

    MATRIZ(1L),
    FILIAL(2L);

    private Long value;

    TipoContaEnum(Long value){
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
