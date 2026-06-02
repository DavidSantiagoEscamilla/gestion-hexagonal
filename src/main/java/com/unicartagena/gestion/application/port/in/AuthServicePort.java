package com.unicartagena.gestion.application.port.in;

/**
 * Puerto de ENTRADA para la autenticacion (login).
 * Recibe credenciales y devuelve un token JWT.
 */
public interface AuthServicePort {
    String login(String cedula, String clave);
}
