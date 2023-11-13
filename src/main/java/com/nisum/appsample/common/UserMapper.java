package com.nisum.appsample.common;

import java.util.ArrayList;

import com.nisum.appsample.infraestructure.usuario.entities.TelefonoEntity;
import com.nisum.appsample.infraestructure.usuario.entities.UsuarioEntity;
import com.nisum.appsample.presentation.usuario.request.TelefonoRequest;
import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;


public class UserMapper {
    public static UsuarioRequest entityToDomain(UsuarioEntity usuarioentity) {
        UsuarioRequest usuario = new UsuarioRequest();
        usuario.setCreated(usuarioentity.getCreated());
        usuario.setEmail(usuarioentity.getEmail());
        usuario.setId(usuarioentity.getId());
        usuario.setIsactive(usuarioentity.isIsactive());
        usuario.setLastLogin(usuarioentity.getLastLogin());
        usuario.setModified(usuarioentity.getModified());
        usuario.setName(usuarioentity.getName());
        usuario.setPassword(usuarioentity.getPassword());
        usuario.setPhones(new ArrayList<TelefonoRequest>());
        for (TelefonoEntity telefonoentity : usuarioentity.getPhones()) {
            TelefonoRequest telefono = new TelefonoRequest();
            telefono.setCitycode(telefonoentity.getCitycode());
            telefono.setContrycode(telefonoentity.getContrycode());
            telefono.setId(telefonoentity.getId());
            telefono.setNumber(telefonoentity.getNumber());
            telefono.setUsuario(usuario);
            usuario.getPhones().add(telefono);
        }
        usuario.setToken(usuarioentity.getToken());
        return usuario;
    }

    public static UsuarioEntity domainToEntity(UsuarioRequest usuario) {
        UsuarioEntity usuarioentity = new UsuarioEntity();
        usuarioentity.setCreated(usuario.getCreated());
        usuarioentity.setEmail(usuario.getEmail());
        usuarioentity.setId(usuario.getId());
        usuarioentity.setIsactive(usuario.isIsactive());
        usuarioentity.setLastLogin(usuario.getLastLogin());
        usuarioentity.setModified(usuario.getModified());
        usuarioentity.setName(usuario.getName());
        usuarioentity.setPassword(usuario.getPassword());
        usuarioentity.setPhones(new ArrayList<TelefonoEntity>());
        for (TelefonoRequest telefono : usuario.getPhones()) {
            TelefonoEntity telefonoentity = new TelefonoEntity();
            telefonoentity.setCitycode(telefono.getCitycode());
            telefonoentity.setContrycode(telefono.getContrycode());
            telefonoentity.setId(telefono.getId());
            telefonoentity.setNumber(telefono.getNumber());
            telefonoentity.setUsuario(usuarioentity);
            usuarioentity.getPhones().add(telefonoentity);
        }
        usuarioentity.setToken(usuario.getToken());
        return usuarioentity;
    }
}
