package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class StatusContaInvalidoException extends RuntimeException{

    public StatusContaInvalidoException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Status de Conta Inválido.";
    }

}
