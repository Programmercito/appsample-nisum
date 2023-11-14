package com.nisum.appsample.presentation.usuario.controllers;

import com.nisum.appsample.common.AutoCall;
import com.nisum.appsample.common.WebAdapter;
import com.nisum.appsample.domain.usuario.CreateUserPort;
import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Esta clase proporciona un controlador para el endpoint "/user". El método
 * "insert" se utiliza para crear un nuevo usuario.
 *
 * @author programmercito
 */
@WebAdapter
public class UsuarioController {

    @AutoCall
    CreateUserPort userservice;
    
    /**
     * Este método se utiliza para crear un nuevo usuario.
     *
     * @param usuario El usuario que se va a crear.
     * @return Un objeto ResponseEntity que contiene el usuario creado.
     */
    @Operation(summary = "Crear un nuevo usuario")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity insert(@RequestBody UsuarioRequest usuario) {
        System.out.println("ENTRANDO");
        UsuarioRequest user = userservice.save(usuario);
        return ResponseEntity.ok(user);
    }

}
