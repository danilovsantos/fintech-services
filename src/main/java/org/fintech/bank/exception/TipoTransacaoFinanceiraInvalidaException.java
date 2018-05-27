package org.fintech.bank.exception;

public class TipoTransacaoFinanceiraInvalidaException extends RuntimeException{

    public TipoTransacaoFinanceiraInvalidaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Tipo Transação Financeira Inválido.";
    }
}
