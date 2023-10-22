package com.nisum.appsample.model.services;

import com.nisum.appsample.controler.jwt.JwtUtil;
import com.nisum.appsample.model.entities.Usuario;
import com.nisum.appsample.model.repository.UsuarioRepository;
import com.nisum.appsample.password.PasswordService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmercito
 */
@Service
public class UsuarioService {

    @Autowired
    private Environment env;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        Date fec = new Date();

        if (usuario.getId() == null) {
            usuario.setCreated(fec);
            usuario.setModified(fec);
            usuario.setLastLogin(fec);
        } else {
            usuario.setModified(fec);
        }
        usuario.setToken(JwtUtil.generateJWT(usuario.getEmail(), env.getProperty("secret"), 9000));
        usuario.setIsactive(true);
        usuario.setPassword(PasswordService.cryptPass(usuario.getPassword(), env.getProperty("salt")));
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
