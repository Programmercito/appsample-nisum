package com.nisum.appsample.controlers;

import com.nisum.appsample.model.entities.Usuario;
import com.nisum.appsample.model.services.UsuarioService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author programmercito
 */
@RestController
@Validated
public class UsuarioController {

    @Autowired
    UsuarioService userservice;

    @Operation(summary = "Crear un nuevo usuario")

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity insert(@Valid @RequestBody Usuario usuario) {
        System.out.println("ENTRANDO");
        Usuario user = userservice.save(usuario);
        return ResponseEntity.ok(user);
    }

}
