package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class ContaDestinoBloqueadaException extends RuntimeException{

    public ContaDestinoBloqueadaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Destino Bloqueada.";
    }

}
