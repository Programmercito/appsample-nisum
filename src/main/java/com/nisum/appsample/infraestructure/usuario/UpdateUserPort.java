package com.nisum.appsample.infraestructure.usuario;

import com.nisum.appsample.infraestructure.usuario.entities.UsuarioEntity;
import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;

public interface UpdateUserPort {
    public UsuarioEntity save(UsuarioEntity usuario);

}
