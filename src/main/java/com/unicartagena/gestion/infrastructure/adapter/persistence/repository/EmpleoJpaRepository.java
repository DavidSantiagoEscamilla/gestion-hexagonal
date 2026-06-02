package com.unicartagena.gestion.infrastructure.adapter.persistence.repository;

import com.unicartagena.gestion.infrastructure.adapter.persistence.entity.EmpleoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio Spring Data JPA para EmpleoEntity (infraestructura).
 */
public interface EmpleoJpaRepository extends JpaRepository<EmpleoEntity, Long> {
}
