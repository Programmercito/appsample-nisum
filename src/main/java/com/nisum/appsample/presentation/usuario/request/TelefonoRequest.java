package com.nisum.appsample.presentation.usuario.request;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Data;

/**
 * Clase Telefono que representa la entidad Telefono en la base de datos.
 *
 * @author programmercito
 */
@Data
public class TelefonoRequest implements Serializable {
    private String id;  // Este campo es el identificador único del teléfono.
    private String number;  // Este campo almacena el número de teléfono.
    private String citycode;  // Este campo almacena el código de la ciudad.
    private String contrycode;  // Este campo almacena el código del país.
    private UsuarioRequest usuario;  // Este campo establece una relación con la entidad Usuario. Cada teléfono está asociado a un usuario.
}
