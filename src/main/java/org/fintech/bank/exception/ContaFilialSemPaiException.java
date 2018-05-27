package org.fintech.bank.exception;

public class ContaFilialSemPaiException extends RuntimeException{

    public ContaFilialSemPaiException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Filial deve possuir uma conta Pai.";
    }
}
