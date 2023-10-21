/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nisum.appsample.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.util.Date;
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
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    @Column(name = "name")
    @JsonIgnore

    private String name;
    @Column(name = "email", unique = true)
    @Email(regexp = "^[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$", message = "mail no valido")
    @JsonIgnore
    private String email;
    @Column(name = "password", nullable = true)
    @JsonIgnore
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+$", message = "password no valido")
    private String password;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Telefono> phones;
    @Column(name = "created")
    private Date created;
    @Column(name = "modified")
    private Date modified;
    @Column(name = "last_login")
    @JsonProperty("last_login")
    private Date lastLogin;
    @Column(name = "isactive")
    private boolean isactive = true;
    @Column(name = "token")
    private String token;

    public void setPhones(List<Telefono> phones) {
        for (Telefono telefono : phones) {
            telefono.setUsuario(this);
        }
        this.phones = phones;
    }
}
