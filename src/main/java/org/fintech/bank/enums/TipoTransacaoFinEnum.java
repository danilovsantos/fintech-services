package org.fintech.bank.enums;

public enum TipoTransacaoFinEnum {

    TRANSFERENCIA(1L),
    ESTORNO(2L);

    private Long value;

    TipoTransacaoFinEnum(Long value){
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
