package com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.response;

/** DTO de respuesta de Empleo. */
public record EmpleoResponse(
        Long id, String nombre, String categoria, String areaTrabajo, String empresa,
        String nivel, Double sueldo, String funciones, String cargoJefe
) {}
