package org.fintech.bank.exception;

public class ContaDestinoInvalidaException extends RuntimeException{

    public ContaDestinoInvalidaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Conta Destino Inválida.";
    }
}
