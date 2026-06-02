package com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request;

import jakarta.validation.constraints.NotBlank;

/** DTO de peticion para el login. */
public record LoginRequest(
        @NotBlank(message = "La cedula es obligatoria") String cedula,
        @NotBlank(message = "La clave es obligatoria") String clave
) {}
