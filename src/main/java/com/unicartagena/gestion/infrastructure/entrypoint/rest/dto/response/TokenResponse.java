package com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.response;

/** DTO de respuesta del login con el token JWT. */
public record TokenResponse(String token, String tipo) {
    public TokenResponse(String token) {
        this(token, "Bearer");
    }
}
