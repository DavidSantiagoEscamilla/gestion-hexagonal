package com.unicartagena.gestion.infrastructure.adapter.persistence.repository;

import com.unicartagena.gestion.infrastructure.adapter.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio Spring Data JPA para UsuarioEntity (infraestructura).
 */
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, String> {
}
