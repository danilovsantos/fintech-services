package org.fintech.bank.exception;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Saldo Insuficiente Para Esta Transação.";
    }
}
