package com.unicartagena.gestion.infrastructure.adapter.persistence;

import com.unicartagena.gestion.application.port.out.UsuarioRepositoryPort;
import com.unicartagena.gestion.domain.model.Usuario;
import com.unicartagena.gestion.infrastructure.adapter.persistence.entity.UsuarioEntity;
import com.unicartagena.gestion.infrastructure.adapter.persistence.mapper.UsuarioPersistenceMapper;
import com.unicartagena.gestion.infrastructure.adapter.persistence.repository.UsuarioJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de SALIDA: implementa el puerto UsuarioRepositoryPort usando JPA.
 * Aqui es donde la abstraccion del dominio se conecta con la tecnologia concreta.
 */
@Component
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepository;
    private final UsuarioPersistenceMapper mapper;

    public UsuarioPersistenceAdapter(UsuarioJpaRepository jpaRepository, UsuarioPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity guardado = jpaRepository.save(mapper.aEntity(usuario));
        return mapper.aDominio(guardado);
    }

    @Override
    public Optional<Usuario> buscarPorCedula(String cedula) {
        return jpaRepository.findById(cedula).map(mapper::aDominio);
    }

    @Override
    public List<Usuario> listar() {
        return jpaRepository.findAll().stream().map(mapper::aDominio).toList();
    }

    @Override
    public boolean existePorCedula(String cedula) {
        return jpaRepository.existsById(cedula);
    }

    @Override
    public void eliminar(String cedula) {
        jpaRepository.deleteById(cedula);
    }
}
