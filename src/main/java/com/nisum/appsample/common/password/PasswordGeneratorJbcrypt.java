package com.nisum.appsample.common.password;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Clase de servicio para el manejo de contraseñas.
 *
 * @author programmercito
 */
public class PasswordGenerator {

    /**
     * Método para encriptar una contraseña.
     *
     * @param mensaje la contraseña a encriptar.
     * @param salt el salt para la encriptación.
     * @return la contraseña encriptada.
     */
    public static String cryptPass(String mensaje, String salt) {
        String decopro = new String(Base64.getUrlDecoder().decode(salt), StandardCharsets.UTF_8);
        String hashedPassword = BCrypt.hashpw(mensaje, decopro);
        return hashedPassword;
    }
}
