package com.nisum.appsample.infraestructure.usuario;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.appsample.common.UserMapper;
import com.nisum.appsample.common.jwt.JwtGenerator;
import com.nisum.appsample.common.password.PasswordGenerator;
import com.nisum.appsample.infraestructure.usuario.entities.UsuarioEntity;
import com.nisum.appsample.infraestructure.usuario.repository.UsuarioRepository;

import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;

public class UpdateUserService implements UpdateUserPort {
    @Autowired
    UsuarioRepository usuariorepository;

    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuariorepository.save(usuario);
    }



}
