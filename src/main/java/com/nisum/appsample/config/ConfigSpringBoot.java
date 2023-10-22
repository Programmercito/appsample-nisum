package com.nisum.appsample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Esta clase es una configuración de Spring Boot. Se utiliza para configurar la
 * URL del origen de datos.
 * @author programmercito
 */
@Configuration
public class ConfigSpringBoot {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;
}
