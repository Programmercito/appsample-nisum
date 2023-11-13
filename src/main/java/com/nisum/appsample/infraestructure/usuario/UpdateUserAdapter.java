package com.nisum.appsample.infraestructure.usuario;

import com.nisum.appsample.common.AutoCall;
import com.nisum.appsample.common.PersistenceAdapter;
import com.nisum.appsample.infraestructure.usuario.entities.UsuarioEntity;
import com.nisum.appsample.infraestructure.usuario.repository.UsuarioRepository;
import com.nisum.appsample.infraestructure.usuario.UpdateUserPort;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@PersistenceAdapter
@Validated
public class UpdateUserAdapter implements UpdateUserPort {

    @AutoCall
    UsuarioRepository usuariorepository;

    @Override
    public UsuarioEntity save(@Valid UsuarioEntity usuario) {
        return usuariorepository.save(usuario);
    }

}
