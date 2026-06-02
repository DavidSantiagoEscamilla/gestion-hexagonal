package com.unicartagena.gestion.application.port.in;

import com.unicartagena.gestion.domain.model.Empleo;
import java.util.List;

/**
 * Puerto de ENTRADA para los casos de uso de Empleo.
 */
public interface EmpleoServicePort {
    Empleo crear(Empleo empleo);
    Empleo buscarPorId(Long id);
    List<Empleo> listar();
    Empleo actualizar(Long id, Empleo empleo);
    void eliminar(Long id);
}
