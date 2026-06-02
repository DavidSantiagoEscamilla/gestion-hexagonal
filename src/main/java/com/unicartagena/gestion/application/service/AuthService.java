package com.unicartagena.gestion.application.service;

import com.unicartagena.gestion.application.port.in.AuthServicePort;
import com.unicartagena.gestion.application.port.out.PasswordEncoderPort;
import com.unicartagena.gestion.application.port.out.TokenProviderPort;
import com.unicartagena.gestion.application.port.out.UsuarioRepositoryPort;
import com.unicartagena.gestion.domain.exception.CredencialesInvalidasException;
import com.unicartagena.gestion.domain.model.Usuario;
import org.springframework.stereotype.Service;

/**
 * Servicio de aplicacion para autenticacion.
 * Valida credenciales y delega la generacion del token al puerto de salida.
 */
@Service
public class AuthService implements AuthServicePort {

    private final UsuarioRepositoryPort usuarioRepository;
    private final PasswordEncoderPort passwordEncoder;
    private final TokenProviderPort tokenProvider;

    public AuthService(UsuarioRepositoryPort usuarioRepository,
                       PasswordEncoderPort passwordEncoder,
                       TokenProviderPort tokenProvider) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public String login(String cedula, String clave) {
        Usuario usuario = usuarioRepository.buscarPorCedula(cedula)
                .orElseThrow(() -> new CredencialesInvalidasException("Cedula o clave incorrectas"));

        if (!passwordEncoder.coincide(clave, usuario.getClave())) {
            throw new CredencialesInvalidasException("Cedula o clave incorrectas");
        }
        return tokenProvider.generarToken(usuario.getCedula());
    }
}
