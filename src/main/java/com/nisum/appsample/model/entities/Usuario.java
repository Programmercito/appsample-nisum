/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nisum.appsample.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.util.UUID;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author programmercito
 */
@Entity
@Table
@Data
@Validated
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "El correo electrónico no es válido")
    private String email;
    @Column(name = "password", nullable = true)
    private String password;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Telefono> phones;

}
