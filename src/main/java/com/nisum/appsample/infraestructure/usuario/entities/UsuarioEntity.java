package com.nisum.appsample.infraestructure.usuario.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * Clase Usuario que representa la entidad Usuario en la base de datos.
 *
 * @author programmercito
 */
@Entity  // Esta anotación indica que esta clase es una entidad.
@Table(name = "USUARIO") // Esta anotación permite especificar detalles de la tabla correspondiente a esta entidad.
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

public class UsuarioEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;  // Este campo es el identificador único del usuario.

    @Column(name = "name")
    @Size(max = 50, message = "El nombre debe tener un máximo de 50 caracteres")
    private String name;  // Este campo almacena el nombre del usuario.

    @Column(name = "email", unique = true)
    @Size(max = 200, message = "El correo electrónico debe tener un máximo de 200 caracteres")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            flags = {Pattern.Flag.CASE_INSENSITIVE}, message = "email no valido")
    private String email;  // Este campo almacena el correo electrónico del usuario.

    @Transient
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\\\\\]{};':\"\\\\\\\\|,.<>/?]*).{14,20}$",
            flags = {Pattern.Flag.CASE_INSENSITIVE}, message = "password no valido")
    private String password;

    @Column(name = "password")
    private String passwordReal;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<TelefonoEntity> phones;  // Este campo establece una relación uno a muchos con la entidad Telefono. Un usuario puede tener varios teléfonos.

    @Column(name = "created")
    private Date created;  // Este campo almacena la fecha en que se creó el usuario.

    @Column(name = "modified")
    private Date modified;  // Este campo almacena la fecha en que se modificó el usuario.

    @Column(name = "last_login")
    private Date lastLogin;  // Este campo almacena la fecha del último inicio de sesión del usuario.

    @Column(name = "isactive")
    private boolean isactive = true;  // Este campo indica si el usuario está activo o no.

    @Column(name = "token")
    private String token;  // Este campo almacena el token del usuario.

    public void setPhones(List<TelefonoEntity> phones) {
        for (TelefonoEntity telefono : phones) {
            telefono.setUsuario(this);
        }
        this.phones = phones;  // Este método establece los teléfonos del usuario y establece la relación con la entidad Telefono.
    }
}
