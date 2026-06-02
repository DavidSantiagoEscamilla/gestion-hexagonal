package com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/** DTO de peticion para actualizar un usuario (la clave es opcional). */
public record ActualizarUsuarioRequest(
        @NotBlank(message = "El nombre es obligatorio") String nombre,
        @Email(message = "El email no es valido") String email,
        String clave
) {}
