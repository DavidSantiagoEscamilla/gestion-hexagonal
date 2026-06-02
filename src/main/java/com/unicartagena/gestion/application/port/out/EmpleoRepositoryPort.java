package com.unicartagena.gestion.application.port.out;

import com.unicartagena.gestion.domain.model.Empleo;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de SALIDA para la persistencia de Empleo.
 */
public interface EmpleoRepositoryPort {
    Empleo guardar(Empleo empleo);
    Optional<Empleo> buscarPorId(Long id);
    List<Empleo> listar();
    boolean existePorId(Long id);
    void eliminar(Long id);
}
