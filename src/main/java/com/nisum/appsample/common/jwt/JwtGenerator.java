package com.nisum.appsample.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;

/**
 * Esta clase proporciona una utilidad para generar tokens JWT. Se utiliza para
 * generar tokens JWT que se utilizan para autenticar y autorizar solicitudes.
 *
 * @author programmercito
 */
public class JwtGenerator {

    /**
     * Este método genera un token JWT.
     *
     * @param subject El sujeto del token.
     * @param secretKey La clave secreta utilizada para firmar el token.
     * @param minutes La duración del token en minutos.
     * @return El token JWT generado.
     */
    public static String generateJWT(String subject, String secretKey, int minutes) {

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        Date now = new Date();

        com.auth0.jwt.JWTCreator.Builder builder = JWT.create()
                .withSubject(subject)
                .withIssuer("appsample")
                .withAudience("nisum.com")
                .withIssuedAt(now)
                .withExpiresAt(new Date(now.getTime() + minutes * 60 * 1000));

        return builder.sign(algorithm);

    }

}
