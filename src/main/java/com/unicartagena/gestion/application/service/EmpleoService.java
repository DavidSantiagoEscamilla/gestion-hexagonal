package com.unicartagena.gestion.application.service;

import com.unicartagena.gestion.application.port.in.EmpleoServicePort;
import com.unicartagena.gestion.application.port.out.EmpleoRepositoryPort;
import com.unicartagena.gestion.domain.exception.RecursoNoEncontradoException;
import com.unicartagena.gestion.domain.model.Empleo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de aplicacion para Empleo. Implementa el CRUDL (puerto IN).
 */
@Service
public class EmpleoService implements EmpleoServicePort {

    private final EmpleoRepositoryPort empleoRepository;

    public EmpleoService(EmpleoRepositoryPort empleoRepository) {
        this.empleoRepository = empleoRepository;
    }

    @Override
    public Empleo crear(Empleo empleo) {
        empleo.setId(null); // garantiza creacion, no actualizacion
        return empleoRepository.guardar(empleo);
    }

    @Override
    public Empleo buscarPorId(Long id) {
        return empleoRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe el empleo con id " + id));
    }

    @Override
    public List<Empleo> listar() {
        return empleoRepository.listar();
    }

    @Override
    public Empleo actualizar(Long id, Empleo datos) {
        Empleo existente = buscarPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setCategoria(datos.getCategoria());
        existente.setAreaTrabajo(datos.getAreaTrabajo());
        existente.setEmpresa(datos.getEmpresa());
        existente.setNivel(datos.getNivel());
        existente.setSueldo(datos.getSueldo());
        existente.setFunciones(datos.getFunciones());
        existente.setCargoJefe(datos.getCargoJefe());
        return empleoRepository.guardar(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!empleoRepository.existePorId(id)) {
            throw new RecursoNoEncontradoException("No existe el empleo con id " + id);
        }
        empleoRepository.eliminar(id);
    }
}
