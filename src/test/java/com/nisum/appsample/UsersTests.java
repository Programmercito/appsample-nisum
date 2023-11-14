package com.nisum.appsample;

import com.nisum.appsample.common.UserMapper;
import com.nisum.appsample.infraestructure.usuario.entities.TelefonoEntity;
import com.nisum.appsample.infraestructure.usuario.entities.UsuarioEntity;
import com.nisum.appsample.infraestructure.usuario.repository.UsuarioRepository;
import com.nisum.appsample.presentation.usuario.controllers.UsuarioController;
import com.nisum.appsample.presentation.usuario.request.TelefonoRequest;
import com.nisum.appsample.presentation.usuario.request.UsuarioRequest;

import jakarta.validation.ConstraintViolationException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.validation.BindingResult;

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
    public UsuarioRequest init() {

        TelefonoRequest phone = new TelefonoRequest();
        phone.setNumber("1234567");
        phone.setCitycode("1");
        phone.setContrycode("57");

        UsuarioRequest user = new UsuarioRequest();
        user.setName("Juan");
        user.setEmail("juan@email.com");
        user.setPassword("pass14353#gdsd");
        user.setPhones(List.of(phone));

        return user;
    }

    @Test
    public void testInsertInvalidEmail() {
        UsuarioRequest user = this.init();
        user.setEmail("joaquinhotmail.com");
        when(usuarioRepository.save(any())).thenReturn(UserMapper.domainToEntity(user));
        assertThrows(ConstraintViolationException.class, () -> {
            usuarioController.insert(user);
        });
        verify(usuarioRepository, never()).save(any());

    }

    @Test
    public void testInsertInvalidPassword() {
        UsuarioRequest user = this.init();
        //user.setPassword("joaqjhgjjhjhgjhghj");
        user.setPassword("DDDDDjhgfjgfjfddddd333");
        when(usuarioRepository.save(any())).thenReturn(UserMapper.domainToEntity(user));
        assertThrows(ConstraintViolationException.class, () -> {
            usuarioController.insert(user);
        });
        verify(usuarioRepository, never()).save(any());
        //part 2
        user.setPassword("joaq3ds");
        when(usuarioRepository.save(any())).thenReturn(UserMapper.domainToEntity(user));
        assertThrows(ConstraintViolationException.class, () -> {

            usuarioController.insert(user);

        });
        verify(usuarioRepository, never()).save(any());

    }

    @Test
    public void testSizes() {
        UsuarioRequest user = this.init();
        //name con 51 de size deberia fallar
        user.setName("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx2");
        when(usuarioRepository.save(any())).thenReturn(UserMapper.domainToEntity(user));
        assertThrows(ConstraintViolationException.class, () -> {
            usuarioController.insert(user);
        });
        verify(usuarioRepository, never()).save(any());

    }
}
