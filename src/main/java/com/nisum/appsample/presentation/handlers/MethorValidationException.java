package com.nisum.appsample.presentation.handlers;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Esta clase proporciona un controlador para manejar excepciones de validación
 * de método.
 *
 * @author programmercito
 */
@ControllerAdvice
public class MethorValidationException {

    /**
     * Este método maneja excepciones de validación de método.
     *
     * @param ex La excepción que se ha producido.
     * @return Un mapa que contiene un mensaje de error.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMensaje handleMethodArgumentNotValidException(ConstraintViolationException ex) {
        ErrorMensaje error = new ErrorMensaje();
        String mens;
        try {
            Iterator<ConstraintViolation<?>> iterator = ex.getConstraintViolations().iterator();
            mens = "Error inesperado";
            while (iterator.hasNext()) {
                ConstraintViolation<?> cv = iterator.next();
                mens = cv.getMessageTemplate();
            }
        } catch (Exception e) {
            mens = "error inesperado";
        }
        error.setMensaje(mens);
        return error;
    }
}
