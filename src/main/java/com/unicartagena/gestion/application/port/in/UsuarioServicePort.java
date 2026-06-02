package com.unicartagena.gestion.application.port.in;

import com.unicartagena.gestion.domain.model.Usuario;
import java.util.List;

/**
 * Puerto de ENTRADA (driving port) para los casos de uso de Usuario.
 * Define QUE puede hacer la aplicacion, sin importar COMO se invoca (REST, CLI, etc.).
 */
public interface UsuarioServicePort {
    Usuario crear(Usuario usuario);
    Usuario buscarPorCedula(String cedula);
    List<Usuario> listar();
    Usuario actualizar(String cedula, Usuario usuario);
    void eliminar(String cedula);
}
