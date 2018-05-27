package org.fintech.bank.exception;

public class TipoContaInvalidoException extends RuntimeException{

    private Long idTipoConta;

    public TipoContaInvalidoException(Long idTipoConta) {
        super();
        this.idTipoConta = idTipoConta;
    }

    @Override
    public String getMessage() {
        return "Tipo de Conta {"+this.idTipoConta+"} Não Encontrada!";
    }

}
