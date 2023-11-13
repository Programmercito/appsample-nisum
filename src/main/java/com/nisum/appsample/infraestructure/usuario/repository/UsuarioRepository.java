package com.nisum.appsample.model.repository;

import com.nisum.appsample.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz UsuarioRepository que representa el repositorio de la entidad
 * Usuario.
 *
 * @author programmercito
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
