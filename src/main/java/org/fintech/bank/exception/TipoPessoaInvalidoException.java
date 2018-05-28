package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class TipoPessoaInvalidoException extends RuntimeException{

    public TipoPessoaInvalidoException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Tipo de Pessoa Inválido.";
    }
}
