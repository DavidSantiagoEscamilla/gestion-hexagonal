package com.unicartagena.gestion.application.port.out;

/**
 * Puerto de SALIDA para la generacion de tokens JWT.
 */
public interface TokenProviderPort {
    String generarToken(String cedula);
}
