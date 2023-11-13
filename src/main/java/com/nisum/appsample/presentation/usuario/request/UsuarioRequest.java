package com.nisum.appsample.presentation.usuario.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Data  // Anotación de Lombok para generar automáticamente getters y setters.
public class UsuarioRequest implements Serializable {

    private String id;  // Este campo es el identificador único del usuario.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String name;  // Este campo almacena el nombre del usuario.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;  // Este campo almacena el correo electrónico del usuario.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;  // Este campo almacena la contraseña del usuario.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordReal;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TelefonoRequest> phones;  // Este campo establece una relación uno a muchos con la entidad Telefono. Un usuario puede tener varios teléfonos.
    private Date created;  // Este campo almacena la fecha en que se creó el usuario.
    private Date modified;  // Este campo almacena la fecha en que se modificó el usuario.
    private Date lastLogin;  // Este campo almacena la fecha del último inicio de sesión del usuario.
    private boolean isactive = true;  // Este campo indica si el usuario está activo o no.
    private String token;  // Este campo almacena el token del usuario.

}
