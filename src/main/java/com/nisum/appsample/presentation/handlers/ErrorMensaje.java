package com.nisum.appsample.presentation.handlers;

import java.io.Serializable;

/**
 *
 * @author programmercito
 */
public class ErrorMensaje implements Serializable {

    private String mensaje;

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
