package com.nisum.appsample.model.entities;

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
@Entity
@Table
@Data
public class Telefono implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;  // Este campo es el identificador único del teléfono.

    @Column(name = "number")
    @Size(max = 50, message = "El numero de telefono debe tener un máximo de 50 caracteres")
    private String number;  // Este campo almacena el número de teléfono.

    @Column(name = "citycode")
    @Size(max = 5, message = "El codigo de ciudad debe tener un máximo de 5 caracteres")
    private String citycode;  // Este campo almacena el código de la ciudad.

    @Column(name = "countrycode")
    @Size(max = 5, message = "El codigo de ciudad debe tener un máximo de 5 caracteres")
    private String contrycode;  // Este campo almacena el código del país.

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;  // Este campo establece una relación con la entidad Usuario. Cada teléfono está asociado a un usuario.
}
