package org.fintech.bank.exception;

public class ContaDestinoBloqueadaException extends RuntimeException{

    public ContaDestinoBloqueadaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Destino Bloqueada.";
    }

}
