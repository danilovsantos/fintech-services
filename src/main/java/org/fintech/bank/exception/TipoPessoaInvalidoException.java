package org.fintech.bank.exception;

public class TipoPessoaInvalidoException extends RuntimeException{

    public TipoPessoaInvalidoException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Tipo de Pessoa Inválido.";
    }
}
