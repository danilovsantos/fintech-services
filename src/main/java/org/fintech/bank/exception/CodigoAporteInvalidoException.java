package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class CodigoAporteInvalidoException extends RuntimeException {

    public CodigoAporteInvalidoException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Código de Aporte Inválido.";
    }
}
