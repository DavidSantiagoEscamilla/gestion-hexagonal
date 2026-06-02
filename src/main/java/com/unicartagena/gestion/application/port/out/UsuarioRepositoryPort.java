package com.unicartagena.gestion.application.port.out;

import com.unicartagena.gestion.domain.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de SALIDA (driven port) para la persistencia de Usuario.
 * La aplicacion depende de esta abstraccion, NO de JPA ni de MySQL.
 * El adaptador de persistencia la implementa.
 */
public interface UsuarioRepositoryPort {
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorCedula(String cedula);
    List<Usuario> listar();
    boolean existePorCedula(String cedula);
    void eliminar(String cedula);
}
