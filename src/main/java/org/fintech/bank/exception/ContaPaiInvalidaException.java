package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class ContaPaiInvalidaException extends RuntimeException{

    public ContaPaiInvalidaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Pai Inválida.";
    }

}
