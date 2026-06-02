package com.unicartagena.gestion.infrastructure.adapter.persistence.mapper;

import com.unicartagena.gestion.domain.model.Empleo;
import com.unicartagena.gestion.infrastructure.adapter.persistence.entity.EmpleoEntity;
import org.springframework.stereotype.Component;

/**
 * Convierte entre el modelo de dominio Empleo y la entidad JPA EmpleoEntity.
 */
@Component
public class EmpleoPersistenceMapper {

    public EmpleoEntity aEntity(Empleo e) {
        EmpleoEntity entity = new EmpleoEntity();
        entity.setId(e.getId());
        entity.setNombre(e.getNombre());
        entity.setCategoria(e.getCategoria());
        entity.setAreaTrabajo(e.getAreaTrabajo());
        entity.setEmpresa(e.getEmpresa());
        entity.setNivel(e.getNivel());
        entity.setSueldo(e.getSueldo());
        entity.setFunciones(e.getFunciones());
        entity.setCargoJefe(e.getCargoJefe());
        return entity;
    }

    public Empleo aDominio(EmpleoEntity e) {
        return new Empleo(e.getId(), e.getNombre(), e.getCategoria(), e.getAreaTrabajo(),
                e.getEmpresa(), e.getNivel(), e.getSueldo(), e.getFunciones(), e.getCargoJefe());
    }
}
