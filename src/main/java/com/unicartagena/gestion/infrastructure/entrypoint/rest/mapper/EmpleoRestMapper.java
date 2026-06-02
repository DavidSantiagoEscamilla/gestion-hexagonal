package com.unicartagena.gestion.infrastructure.entrypoint.rest.mapper;

import com.unicartagena.gestion.domain.model.Empleo;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request.EmpleoRequest;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.response.EmpleoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/** Convierte entre DTOs REST y el modelo de dominio Empleo. */
@Component
public class EmpleoRestMapper {

    public Empleo aDominio(EmpleoRequest req) {
        return new Empleo(null, req.nombre(), req.categoria(), req.areaTrabajo(), req.empresa(),
                req.nivel(), req.sueldo(), req.funciones(), req.cargoJefe());
    }

    public EmpleoResponse aResponse(Empleo e) {
        return new EmpleoResponse(e.getId(), e.getNombre(), e.getCategoria(), e.getAreaTrabajo(),
                e.getEmpresa(), e.getNivel(), e.getSueldo(), e.getFunciones(), e.getCargoJefe());
    }

    public List<EmpleoResponse> aResponseList(List<Empleo> empleos) {
        return empleos.stream().map(this::aResponse).toList();
    }
}
