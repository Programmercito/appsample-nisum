package com.nisum.appsample.password;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author programmercito
 */
public class PasswordService {

    public static String cryptPass(String mensaje, String salt) {
        String decopro = new String(Base64.getUrlDecoder().decode(salt), StandardCharsets.UTF_8);
        String hashedPassword = BCrypt.hashpw(mensaje, decopro);
        return hashedPassword;
    }
}
