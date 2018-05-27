package org.fintech.bank.exception;

public class StatusContaInvalidoException extends RuntimeException{

    private Long idStatusConta;

    public StatusContaInvalidoException(Long idStatusConta) {
        super();
        this.idStatusConta = idStatusConta;
    }

    @Override
    public String getMessage() {
        return "Status de Conta {"+this.idStatusConta+"} Inválido!";
    }

}
