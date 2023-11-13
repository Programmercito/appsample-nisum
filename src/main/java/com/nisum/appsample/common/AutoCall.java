package com.nisum.appsample.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;

/**
 *
 * @author programmercito
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoCall {

    @AliasFor(annotation = Autowired.class)
    String value() default "";
}
