package com.unicartagena.gestion.infrastructure.entrypoint.rest.controller;

import com.unicartagena.gestion.application.port.in.UsuarioServicePort;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request.ActualizarUsuarioRequest;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request.CrearUsuarioRequest;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.response.UsuarioResponse;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.mapper.UsuarioRestMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Adaptador de ENTRADA REST para Usuario.
 * Expone el CRUDL como endpoints HTTP.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioServicePort usuarioService;
    private final UsuarioRestMapper mapper;

    public UsuarioController(UsuarioServicePort usuarioService, UsuarioRestMapper mapper) {
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    // POST /api/usuarios -> crear
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse crear(@Valid @RequestBody CrearUsuarioRequest request) {
        return mapper.aResponse(usuarioService.crear(mapper.aDominio(request)));
    }

    // GET /api/usuarios -> listar
    @GetMapping
    public List<UsuarioResponse> listar() {
        return mapper.aResponseList(usuarioService.listar());
    }

    // GET /api/usuarios/{cedula} -> obtener uno
    @GetMapping("/{cedula}")
    public UsuarioResponse obtener(@PathVariable String cedula) {
        return mapper.aResponse(usuarioService.buscarPorCedula(cedula));
    }

    // PUT /api/usuarios/{cedula} -> actualizar
    @PutMapping("/{cedula}")
    public UsuarioResponse actualizar(@PathVariable String cedula,
                                      @Valid @RequestBody ActualizarUsuarioRequest request) {
        return mapper.aResponse(usuarioService.actualizar(cedula, mapper.aDominio(request)));
    }

    // DELETE /api/usuarios/{cedula} -> eliminar
    @DeleteMapping("/{cedula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable String cedula) {
        usuarioService.eliminar(cedula);
    }
}
