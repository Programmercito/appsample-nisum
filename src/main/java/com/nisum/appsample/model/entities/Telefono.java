package com.nisum.appsample.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.PrePersist;
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

    @PrePersist
    public void generarId() {
        this.id = UUID.randomUUID().toString();
    }
}
