package com.nisum.appsample.model.repository;

import com.nisum.appsample.model.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hered
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
