package com.nisum.appsample.domain.usuario;
import com.nisum.appsample.common.UseCase;
import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;
/**
 *
 * @author programmercito
 */
@UseCase
public interface CreateUserPort {
    public UsuarioRequest save(UsuarioRequest usuario);
}