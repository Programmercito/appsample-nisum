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
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 50, message = "El nombre debe tener un máximo de 50 caracteres")
    private String name;
    @Column(name = "email", unique = true)
    @Size(max = 200, message = "El correo electrónico debe tener un máximo de 200 caracteres")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            flags = {Pattern.Flag.CASE_INSENSITIVE}, message = "email no valido")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    @Column(name = "password", nullable = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            flags = {Pattern.Flag.CASE_INSENSITIVE}, message = "password no valido")
    private String password;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
