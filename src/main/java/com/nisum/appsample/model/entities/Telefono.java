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
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author programmercito
 */
@Entity
@Table
@Data
class Telefono implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    @Column(name = "number")
    private String number;
    @Column(name = "citycode")
    private String citycode;
    @Column(name = "countrycode")
    private String contrycode;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
