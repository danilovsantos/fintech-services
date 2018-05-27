package org.fintech.bank.exception;

public class ContaDestinoCanceladaException extends RuntimeException {

    public ContaDestinoCanceladaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Destino Cancelada.";
    }

}
