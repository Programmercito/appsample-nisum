/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nisum.appsample.controlers;

import com.nisum.appsample.model.entities.Usuario;
import com.nisum.appsample.model.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hered
 */
@RestController
public class UsuarioControler {

    @Autowired
    UsuarioRepository userservice;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity insert(@Valid @RequestBody Usuario usuario) {
        Usuario user = userservice.save(usuario);
        return ResponseEntity.ok(user);
    }
}
