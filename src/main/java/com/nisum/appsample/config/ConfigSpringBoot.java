package com.nisum.appsample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author programmercito
 */
@Configuration
public class ConfigSpringBoot {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;
}
