package com.unicartagena.gestion.infrastructure.entrypoint.rest.controller;

import com.unicartagena.gestion.application.port.in.EmpleoServicePort;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request.EmpleoRequest;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.response.EmpleoResponse;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.mapper.EmpleoRestMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Adaptador de ENTRADA REST para Empleo (tabla asignada).
 * Expone el CRUDL como endpoints HTTP.
 */
@RestController
@RequestMapping("/api/empleos")
public class EmpleoController {

    private final EmpleoServicePort empleoService;
    private final EmpleoRestMapper mapper;

    public EmpleoController(EmpleoServicePort empleoService, EmpleoRestMapper mapper) {
        this.empleoService = empleoService;
        this.mapper = mapper;
    }

    // POST /api/empleos -> crear
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleoResponse crear(@Valid @RequestBody EmpleoRequest request) {
        return mapper.aResponse(empleoService.crear(mapper.aDominio(request)));
    }

    // GET /api/empleos -> listar
    @GetMapping
    public List<EmpleoResponse> listar() {
        return mapper.aResponseList(empleoService.listar());
    }

    // GET /api/empleos/{id} -> obtener uno
    @GetMapping("/{id}")
    public EmpleoResponse obtener(@PathVariable Long id) {
        return mapper.aResponse(empleoService.buscarPorId(id));
    }

    // PUT /api/empleos/{id} -> actualizar
    @PutMapping("/{id}")
    public EmpleoResponse actualizar(@PathVariable Long id, @Valid @RequestBody EmpleoRequest request) {
        return mapper.aResponse(empleoService.actualizar(id, mapper.aDominio(request)));
    }

    // DELETE /api/empleos/{id} -> eliminar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        empleoService.eliminar(id);
    }
}
