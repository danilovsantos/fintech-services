package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class ContaOrigemBloqueadaException extends RuntimeException{

    public ContaOrigemBloqueadaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Origem Bloqueada.";
    }

}
