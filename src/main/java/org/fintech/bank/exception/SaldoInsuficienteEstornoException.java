package org.fintech.bank.exception;

public class SaldoInsuficienteEstornoException extends RuntimeException{

    public SaldoInsuficienteEstornoException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Saldo insuficiente na conta destino para realizar estorno.";
    }
}
