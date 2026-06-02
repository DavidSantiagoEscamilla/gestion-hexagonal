package com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.response;

import java.time.LocalDateTime;

/** DTO estandar de respuesta de error. */
public record ApiError(int estado, String mensaje, LocalDateTime fecha) {
    public ApiError(int estado, String mensaje) {
        this(estado, mensaje, LocalDateTime.now());
    }
}
