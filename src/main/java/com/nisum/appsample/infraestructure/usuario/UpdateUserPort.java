package com.nisum.appsample.infraestructure.usuario;

import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;

public interface UpdateUserPort {
    public UsuarioRequest save(UsuarioRequest usuario);

}
