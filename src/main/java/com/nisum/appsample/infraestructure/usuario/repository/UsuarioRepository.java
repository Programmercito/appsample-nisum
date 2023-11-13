package com.nisum.appsample.infraestructure.usuario.repository;

import com.nisum.appsample.infraestructure.usuario.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz UsuarioRepository que representa el repositorio de la entidad
 * Usuario.
 *
 * @author programmercito
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
