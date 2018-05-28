package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */


public class  ContaOrigemCanceladaException extends RuntimeException{

    public ContaOrigemCanceladaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Origem Cancelada.";
    }

}
