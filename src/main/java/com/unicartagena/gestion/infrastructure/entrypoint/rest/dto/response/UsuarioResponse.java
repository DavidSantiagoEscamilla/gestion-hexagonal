package com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.response;

/** DTO de respuesta de Usuario (nunca expone la clave). */
public record UsuarioResponse(String cedula, String nombre, String email) {}
