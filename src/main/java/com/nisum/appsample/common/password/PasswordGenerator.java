package com.nisum.appsample.common.password;

import org.springframework.stereotype.Component;

/**
 *
 * @author programmercito
 *
 */
@Component
public interface PasswordGenerator {
    public String cryptPass(String mensaje, String salt);
}
