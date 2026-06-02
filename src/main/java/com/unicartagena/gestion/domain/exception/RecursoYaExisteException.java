package com.unicartagena.gestion.domain.exception;

/**
 * Excepcion de dominio: se lanza cuando se intenta crear un recurso que ya existe.
 */
public class RecursoYaExisteException extends RuntimeException {
    public RecursoYaExisteException(String mensaje) {
        super(mensaje);
    }
}
