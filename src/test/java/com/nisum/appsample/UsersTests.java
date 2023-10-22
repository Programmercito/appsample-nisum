package com.nisum.appsample;

import com.nisum.appsample.controlers.UsuarioController;
import com.nisum.appsample.model.entities.Telefono;
import com.nisum.appsample.model.entities.Usuario;
import com.nisum.appsample.model.repository.UsuarioRepository;
import com.nisum.appsample.model.services.UsuarioService;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 *
 * @author programmercito
 */
@SpringBootTest
public class UsersTests {

    @Autowired
    private UsuarioController usuarioController;

    @MockBean
    private BindingResult bindingResult;

    @MockBean
    private UsuarioRepository usuarioRepository;

    // inicializo proyecto de prueba
    public Usuario init() {

        Telefono phone = new Telefono();
        phone.setNumber("1234567");
        phone.setCitycode("1");
        phone.setContrycode("57");

        Usuario user = new Usuario();
        user.setName("Juan");
        user.setEmail("juan@email.com");
        user.setPassword("pass14353#gdsd");
        user.setPhones(List.of(phone));

        return user;
    }

    @Test
    public void testInsertInvalidEmail() {
        Usuario user = this.init();
        user.setEmail("joaquinhotmail.com");
        when(usuarioRepository.save(any())).thenReturn(user);
        assertThrows(ConstraintViolationException.class, () -> {
            usuarioController.insert(user);
        });
        verify(usuarioRepository, never()).save(any());

    }

    @Test
    public void testInsertInvalidPassword() {
        Usuario user = this.init();
        user.setPassword("joaq");
        when(usuarioRepository.save(any())).thenReturn(user);
        assertThrows(ConstraintViolationException.class, () -> {
            usuarioController.insert(user);
        });
        verify(usuarioRepository, never()).save(any());

    }
}
