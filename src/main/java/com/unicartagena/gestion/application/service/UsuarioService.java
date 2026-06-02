package com.unicartagena.gestion.application.service;

import com.unicartagena.gestion.application.port.in.UsuarioServicePort;
import com.unicartagena.gestion.application.port.out.PasswordEncoderPort;
import com.unicartagena.gestion.application.port.out.UsuarioRepositoryPort;
import com.unicartagena.gestion.domain.exception.RecursoNoEncontradoException;
import com.unicartagena.gestion.domain.exception.RecursoYaExisteException;
import com.unicartagena.gestion.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de aplicacion para Usuario. Implementa los casos de uso (puerto IN)
 * apoyandose en los puertos de salida (repositorio, cifrado).
 * Aqui vive la logica de orquestacion, sin detalles de infraestructura.
 */
@Service
public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepository;
    private final PasswordEncoderPort passwordEncoder;

    public UsuarioService(UsuarioRepositoryPort usuarioRepository, PasswordEncoderPort passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario crear(Usuario usuario) {
        if (usuarioRepository.existePorCedula(usuario.getCedula())) {
            throw new RecursoYaExisteException("Ya existe un usuario con la cedula " + usuario.getCedula());
        }
        // La clave se cifra antes de persistir
        usuario.setClave(passwordEncoder.cifrar(usuario.getClave()));
        return usuarioRepository.guardar(usuario);
    }

    @Override
    public Usuario buscarPorCedula(String cedula) {
        return usuarioRepository.buscarPorCedula(cedula)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe el usuario con cedula " + cedula));
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.listar();
    }

    @Override
    public Usuario actualizar(String cedula, Usuario datos) {
        Usuario existente = buscarPorCedula(cedula);
        existente.setNombre(datos.getNombre());
        existente.setEmail(datos.getEmail());
        // Si llega una clave nueva, se cifra; si no, se conserva la actual
        if (datos.getClave() != null && !datos.getClave().isBlank()) {
            existente.setClave(passwordEncoder.cifrar(datos.getClave()));
        }
        return usuarioRepository.guardar(existente);
    }

    @Override
    public void eliminar(String cedula) {
        if (!usuarioRepository.existePorCedula(cedula)) {
            throw new RecursoNoEncontradoException("No existe el usuario con cedula " + cedula);
        }
        usuarioRepository.eliminar(cedula);
    }
}
