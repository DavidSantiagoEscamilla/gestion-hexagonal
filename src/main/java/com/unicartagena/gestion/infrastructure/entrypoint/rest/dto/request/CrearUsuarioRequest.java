package com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/** DTO de peticion para crear un usuario. */
public record CrearUsuarioRequest(
        @NotBlank(message = "La cedula es obligatoria") String cedula,
        @NotBlank(message = "La clave es obligatoria") String clave,
        @NotBlank(message = "El nombre es obligatorio") String nombre,
        @Email(message = "El email no es valido") String email
) {}
