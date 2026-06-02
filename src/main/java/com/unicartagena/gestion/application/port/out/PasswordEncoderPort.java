package com.unicartagena.gestion.application.port.out;

/**
 * Puerto de SALIDA para el cifrado de claves.
 * Abstrae el mecanismo concreto (BCrypt) del nucleo de la aplicacion.
 */
public interface PasswordEncoderPort {
    String cifrar(String clavePlana);
    boolean coincide(String clavePlana, String claveCifrada);
}
