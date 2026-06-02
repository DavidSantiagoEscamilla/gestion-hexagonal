package com.unicartagena.gestion.infrastructure.entrypoint.rest.mapper;

import com.unicartagena.gestion.domain.model.Usuario;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request.ActualizarUsuarioRequest;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.request.CrearUsuarioRequest;
import com.unicartagena.gestion.infrastructure.entrypoint.rest.dto.response.UsuarioResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/** Convierte entre DTOs REST y el modelo de dominio Usuario. */
@Component
public class UsuarioRestMapper {

    public Usuario aDominio(CrearUsuarioRequest req) {
        return new Usuario(req.cedula(), req.clave(), req.nombre(), req.email());
    }

    public Usuario aDominio(ActualizarUsuarioRequest req) {
        Usuario u = new Usuario();
        u.setNombre(req.nombre());
        u.setEmail(req.email());
        u.setClave(req.clave());
        return u;
    }

    public UsuarioResponse aResponse(Usuario u) {
        return new UsuarioResponse(u.getCedula(), u.getNombre(), u.getEmail());
    }

    public List<UsuarioResponse> aResponseList(List<Usuario> usuarios) {
        return usuarios.stream().map(this::aResponse).toList();
    }
}
