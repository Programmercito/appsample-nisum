package com.nisum.appsample.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.appsample.infraestructure.usuario.UpdateUserPort;
import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;

public class CreateUserService implements CreateUserPort {

    @Autowired
    UpdateUserPort updateUserPort;

    @Override
    public UsuarioRequest save(UsuarioRequest usuario) {
        return updateUserPort.save(usuario);
    }

}
