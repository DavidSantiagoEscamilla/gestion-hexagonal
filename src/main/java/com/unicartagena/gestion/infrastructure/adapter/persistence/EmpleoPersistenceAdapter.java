package com.unicartagena.gestion.infrastructure.adapter.persistence;

import com.unicartagena.gestion.application.port.out.EmpleoRepositoryPort;
import com.unicartagena.gestion.domain.model.Empleo;
import com.unicartagena.gestion.infrastructure.adapter.persistence.entity.EmpleoEntity;
import com.unicartagena.gestion.infrastructure.adapter.persistence.mapper.EmpleoPersistenceMapper;
import com.unicartagena.gestion.infrastructure.adapter.persistence.repository.EmpleoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de SALIDA: implementa EmpleoRepositoryPort usando JPA.
 */
@Component
public class EmpleoPersistenceAdapter implements EmpleoRepositoryPort {

    private final EmpleoJpaRepository jpaRepository;
    private final EmpleoPersistenceMapper mapper;

    public EmpleoPersistenceAdapter(EmpleoJpaRepository jpaRepository, EmpleoPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Empleo guardar(Empleo empleo) {
        EmpleoEntity guardado = jpaRepository.save(mapper.aEntity(empleo));
        return mapper.aDominio(guardado);
    }

    @Override
    public Optional<Empleo> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(mapper::aDominio);
    }

    @Override
    public List<Empleo> listar() {
        return jpaRepository.findAll().stream().map(mapper::aDominio).toList();
    }

    @Override
    public boolean existePorId(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }
}
