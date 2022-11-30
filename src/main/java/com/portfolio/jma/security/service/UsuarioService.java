
package com.portfolio.jma.security.service;

import com.portfolio.jma.security.entity.Usuario;
import com.portfolio.jma.security.repository.IUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email) {
        return iUsuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario) {
        iUsuarioRepository.save(usuario);
    }
}
