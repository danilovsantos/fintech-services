package org.fintech.bank.exception;

public class ContaPaiNaoLocalizadaException extends RuntimeException{

    private Long idContaPai;

    public ContaPaiNaoLocalizadaException(Long idContaPai) {
        super();
        this.idContaPai = idContaPai;
    }

    @Override
    public String getMessage() {
        return "Conta Pai {"+this.idContaPai+"} Não Localizada!";
    }

}
