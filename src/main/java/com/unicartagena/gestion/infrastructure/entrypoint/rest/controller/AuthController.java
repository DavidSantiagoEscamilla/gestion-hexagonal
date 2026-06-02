package com.unicartagena.gestion.infrastructure.entrypoint.rest.controller;

import com.unicartagena.gestion.application.port.in.AuthServicePort;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request.LoginRequest;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.response.TokenResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Adaptador de ENTRADA REST para autenticacion.
 * POST /api/auth/login -> devuelve un token JWT.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthServicePort authService;

    public AuthController(AuthServicePort authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody LoginRequest request) {
        String token = authService.login(request.cedula(), request.clave());
        return new TokenResponse(token);
    }
}
