package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class ContaFilialSemPaiException extends RuntimeException{

    public ContaFilialSemPaiException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Filial deve possuir uma conta Pai.";
    }
}
