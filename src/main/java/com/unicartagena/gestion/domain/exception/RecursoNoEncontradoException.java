package com.unicartagena.gestion.domain.exception;

/**
 * Excepcion de dominio: se lanza cuando no se encuentra un recurso solicitado.
 */
public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
