package org.fintech.bank.exception;

public class ContaPaiInvalidaException extends RuntimeException{

    public ContaPaiInvalidaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Pai Inválida.";
    }

}
