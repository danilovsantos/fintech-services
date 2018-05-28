package org.fintech.bank.exception;

/**
 * @author Danilo Valente
 */

public class CodigoAporteNuloException extends RuntimeException {

    public CodigoAporteNuloException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Código do Aporte Não Informado.";
    }
}
