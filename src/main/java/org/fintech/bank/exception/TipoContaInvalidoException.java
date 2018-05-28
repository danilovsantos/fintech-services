package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class TipoContaInvalidoException extends RuntimeException{

    public TipoContaInvalidoException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Tipo de Conta Inválido.";
    }

}
