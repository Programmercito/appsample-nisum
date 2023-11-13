package com.nisum.appsample.infraestructure.usuario;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.appsample.common.UserMapper;
import com.nisum.appsample.common.jwt.JwtGenerator;
import com.nisum.appsample.model.entities.UsuarioEntity;
import com.nisum.appsample.model.repository.UsuarioRepository;
import com.nisum.appsample.password.PasswordGenerator;
import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;

public class UpdateUserService implements UpdateUserPort {
    @Autowired
    UsuarioRepository usuariorepository;

    @Override
    public UsuarioRequest save(UsuarioRequest usuario) {
        Date fec = new Date();

        if (usuario.getId() == null) {
            usuario.setCreated(fec);
            usuario.setModified(fec);
            usuario.setLastLogin(fec);
        } else {
            usuario.setModified(fec);
        }
        usuario.setToken(JwtGenerator.generateJWT(usuario.getEmail(), env.getProperty("secret"), 9000));
        usuario.setIsactive(true);
        usuario.setPassword(PasswordGenerator.cryptPass(usuario.getPassword(), env.getProperty("salt")));

        UsuarioEntity usuarioEntity;
        usuarioEntity = UserMapper.domainToEntity(usuario);
        usuarioEntity = usuariorepository.save(usuarioEntity);
        usuario = UserMapper.entityToDomain(usuarioEntity);
        return usuario;
    }

}
