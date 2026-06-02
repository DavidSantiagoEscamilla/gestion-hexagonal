package com.unicartagena.gestion.domain.exception;

/**
 * Excepcion de dominio: credenciales de login invalidas.
 */
public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException(String mensaje) {
        super(mensaje);
    }
}
