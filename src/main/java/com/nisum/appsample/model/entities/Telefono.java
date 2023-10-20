package com.nisum.appsample.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nomber")
    private String number;
    @Column(name = "citycode")
    private String cityCode;
    @Column(name = "countryCode")
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
