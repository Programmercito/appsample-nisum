package com.nisum.appsample.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Data;

/**
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

    private String id;

    @Column(name = "number")
    @Size(max = 50, message = "El numero de telefono debe tener un máximo de 50 caracteres")
    private String number;
    @Column(name = "citycode")
    @Size(max = 5, message = "El codigo de ciudad debe tener un máximo de 5 caracteres")
    private String citycode;
    @Column(name = "countrycode")
    @Size(max = 5, message = "El codigo de ciudad debe tener un máximo de 5 caracteres")
    private String contrycode;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
