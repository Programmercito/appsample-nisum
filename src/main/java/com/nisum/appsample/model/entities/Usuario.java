package com.nisum.appsample.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;
import javax.persistence.PrePersist;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * Clase Usuario que representa la entidad Usuario en la base de datos.
 *
 * @author programmercito
 */
@Entity  // Esta anotación indica que esta clase es una entidad.
@Table  // Esta anotación permite especificar detalles de la tabla correspondiente a esta entidad.
@Data  // Anotación de Lombok para generar automáticamente getters y setters.
@Validated  // Esta anotación se utiliza para validar el objeto.
@Schema(example = "{\n"
        + "  \"name\": \"Juan Rodriguez\",\n"
        + "  \"email\": \"juan@rodriguez.org\",\n"
        + "  \"password\": \"hunter2kkkl43#\",\n"
        + "  \"phones\": [\n"
        + "    {\n"
        + "      \"number\": \"1234567\",\n"
        + "      \"citycode\": \"1\",\n"
        + "      \"contrycode\": \"57\"\n"
        + "    }\n"
        + "  ]\n"
        + "}")  // Esta anotación se utiliza para proporcionar un ejemplo de cómo se ve un objeto Usuario.

public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    private String id;  // Este campo es el identificador único del usuario.

    @Column(name = "name")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 50, message = "El nombre debe tener un máximo de 50 caracteres")
    private String name;  // Este campo almacena el nombre del usuario.

    @Column(name = "email", unique = true, columnDefinition = "")
    @Size(max = 200, message = "El correo electrónico debe tener un máximo de 200 caracteres")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            flags = {Pattern.Flag.CASE_INSENSITIVE}, message = "email no valido")
    private String email;  // Este campo almacena el correo electrónico del usuario.

    @Column(name = "password", nullable = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            flags = {Pattern.Flag.CASE_INSENSITIVE}, message = "password no valido")
    private String password;  // Este campo almacena la contraseña del usuario.

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Telefono> phones;  // Este campo establece una relación uno a muchos con la entidad Telefono. Un usuario puede tener varios teléfonos.

    @Column(name = "created")
    private Date created;  // Este campo almacena la fecha en que se creó el usuario.

    @Column(name = "modified")
    private Date modified;  // Este campo almacena la fecha en que se modificó el usuario.

    @Column(name = "last_login")
    @JsonProperty("last_login")
    private Date lastLogin;  // Este campo almacena la fecha del último inicio de sesión del usuario.

    @Column(name = "isactive")
    private boolean isactive = true;  // Este campo indica si el usuario está activo o no.

    @Column(name = "token")
    private String token;  // Este campo almacena el token del usuario.

    public void setPhones(List<Telefono> phones) {
        for (Telefono telefono : phones) {
            telefono.setUsuario(this);
        }
        this.phones = phones;  // Este método establece los teléfonos del usuario y establece la relación con la entidad Telefono.
    }

    @PrePersist
    public void generarId() {
        this.id = UUID.randomUUID().toString();
    }
}
