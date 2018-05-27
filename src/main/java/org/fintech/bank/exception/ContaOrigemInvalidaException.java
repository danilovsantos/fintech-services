package org.fintech.bank.exception;

public class ContaOrigemInvalidaException extends RuntimeException{

    public ContaOrigemInvalidaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Origem Inválida.";
    }
}
