package com.unicartagena.gestion.infrastructure.security;

import com.unicartagena.gestion.application.port.out.PasswordEncoderPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Adaptador de SALIDA: implementa el cifrado de claves con BCrypt.
 */
@Component
public class BCryptPasswordEncoderAdapter implements PasswordEncoderPort {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String cifrar(String clavePlana) {
        return encoder.encode(clavePlana);
    }

    @Override
    public boolean coincide(String clavePlana, String claveCifrada) {
        return encoder.matches(clavePlana, claveCifrada);
    }
}
