package com.unicartagena.gestion.infrastructure.adapter.persistence.mapper;

import com.unicartagena.gestion.domain.model.Usuario;
import com.unicartagena.gestion.infrastructure.adapter.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

/**
 * Convierte entre el modelo de dominio Usuario y la entidad JPA UsuarioEntity.
 */
@Component
public class UsuarioPersistenceMapper {

    public UsuarioEntity aEntity(Usuario u) {
        return new UsuarioEntity(u.getCedula(), u.getClave(), u.getNombre(), u.getEmail());
    }

    public Usuario aDominio(UsuarioEntity e) {
        return new Usuario(e.getCedula(), e.getClave(), e.getNombre(), e.getEmail());
    }
}
