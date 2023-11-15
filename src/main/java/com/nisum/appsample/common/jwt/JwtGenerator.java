package com.nisum.appsample.common.jwt;

/**
 *
 * @author programmercito
 */
public interface JwtGenerator {

    public String generateJWT(String subject, String secretKey, int minutes);
}
