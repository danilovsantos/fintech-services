package org.fintech.bank.exception;

public class TransacaoFinanceiraIncompativelException extends RuntimeException{

    public TransacaoFinanceiraIncompativelException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Transação incompatível devido a diferença entre tipos de conta.";
    }
}
