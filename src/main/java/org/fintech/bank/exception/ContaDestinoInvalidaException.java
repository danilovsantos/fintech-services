package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class ContaDestinoInvalidaException extends RuntimeException{

    public ContaDestinoInvalidaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Destino Inválida.";
    }
}
