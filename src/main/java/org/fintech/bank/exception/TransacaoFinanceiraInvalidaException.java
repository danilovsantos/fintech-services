package org.fintech.bank.exception;

public class TransacaoFinanceiraInvalidaException extends RuntimeException {

    public TransacaoFinanceiraInvalidaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "ID de Transação Financeira Inválido.";
    }
}
