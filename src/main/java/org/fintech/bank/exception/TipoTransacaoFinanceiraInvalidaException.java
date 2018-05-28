package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class TipoTransacaoFinanceiraInvalidaException extends RuntimeException{

    public TipoTransacaoFinanceiraInvalidaException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Tipo Transação Financeira Selecionado é Inválido.";
    }
}
