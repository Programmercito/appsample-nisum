package com.nisum.appsample.infraestructure.usuario;

import com.nisum.appsample.common.PersistenceAdapter;
import com.nisum.appsample.infraestructure.usuario.entities.UsuarioEntity;
import jakarta.validation.Valid;

@PersistenceAdapter
public interface UpdateUserPort {
    public UsuarioEntity save(@Valid UsuarioEntity usuario);

}
