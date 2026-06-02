package com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/** DTO de peticion para crear/actualizar un empleo. */
public record EmpleoRequest(
        @NotBlank(message = "El nombre es obligatorio") String nombre,
        @NotBlank(message = "La categoria es obligatoria") String categoria,
        @NotBlank(message = "El area de trabajo es obligatoria") String areaTrabajo,
        @NotBlank(message = "La empresa es obligatoria") String empresa,
        @NotBlank(message = "El nivel es obligatorio") String nivel,
        @NotNull(message = "El sueldo es obligatorio") @PositiveOrZero(message = "El sueldo no puede ser negativo") Double sueldo,
        @NotBlank(message = "Las funciones son obligatorias") String funciones,
        @NotBlank(message = "El cargo del jefe es obligatorio") String cargoJefe
) {}
