package com.nisum.appsample.common.jwt;

import org.springframework.stereotype.Component;

/**
 *
 * @author programmercito
 */
@Component
public interface JwtGenerator {

    public String generateJWT(String subject, String secretKey, int minutes);
}
