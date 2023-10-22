/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nisum.appsample.controlers;

import com.nisum.appsample.model.entities.Usuario;
import com.nisum.appsample.model.entities.Telefono;
import com.nisum.appsample.model.repository.UsuarioRepository;
import com.nisum.appsample.model.services.UsuarioService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

/**
 *
 * @author hered
 */
@RestController
public class UsuarioControler {

    @Autowired
    UsuarioService userservice;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity insert(@Valid @RequestBody Usuario usuario) {
        Usuario user = userservice.save(usuario);
        return ResponseEntity.ok(user);
    }

}
