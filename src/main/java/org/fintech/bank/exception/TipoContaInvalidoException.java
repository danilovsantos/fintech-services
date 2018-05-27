package org.fintech.bank.exception;

public class TipoContaInvalidoException extends RuntimeException{

    public TipoContaInvalidoException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Tipo de Conta Inválido.";
    }

}
