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
 * Clase de servicio para el manejo de usuarios.
 *
 * @author programmercito
 */
@Service
public class UsuarioService {

    // Propiedad para manejar variables de entorno.
    @Autowired
    private Environment env;

    // Repositorio para realizar operaciones CRUD en usuarios.
    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Método para obtener todos los usuarios.
     *
     * @return lista de usuarios.
     */
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    /**
     * Método para buscar un usuario por su ID.
     *
     * @param id del usuario.
     * @return usuario encontrado.
     */
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Método para guardar un usuario.
     *
     * @param usuario a guardar.
     * @return usuario guardado.
     */
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

    /**
     * Método para eliminar un usuario por su ID.
     *
     * @param id del usuario a eliminar.
     */
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
