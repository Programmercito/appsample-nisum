package com.nisum.appsample.domain.usuario;


import com.nisum.appsample.common.AutoCall;
import com.nisum.appsample.common.UserMapper;
import com.nisum.appsample.common.jwt.JwtGenerator;
import com.nisum.appsample.common.password.PasswordGenerator;
import com.nisum.appsample.infraestructure.usuario.UpdateUserPort;
import com.nisum.appsample.infraestructure.usuario.entities.UsuarioEntity;
import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;
import java.util.Date;
import org.springframework.core.env.Environment;

public class CreateUserService implements CreateUserPort {

    @AutoCall
    UpdateUserPort updateUserPort;

    @AutoCall
    private Environment env;

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
        UsuarioEntity ue = UserMapper.domainToEntity(usuario);
        return UserMapper.entityToDomain(updateUserPort.save(ue));

    }

}
