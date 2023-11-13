package com.nisum.appsample.infraestructure.usuario;

import com.nisum.appsample.common.AutoCall;
import com.nisum.appsample.infraestructure.usuario.entities.UsuarioEntity;
import com.nisum.appsample.infraestructure.usuario.repository.UsuarioRepository;
import com.nisum.appsample.infraestructure.usuario.UpdateUserPort;

public class UpdateUserAdapter implements UpdateUserPort {

    @AutoCall
    UsuarioRepository usuariorepository;

    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuariorepository.save(usuario);
    }

}
