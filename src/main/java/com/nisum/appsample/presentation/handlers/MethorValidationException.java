package com.nisum.appsample.handlers;

import java.util.HashMap;
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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> response = new HashMap<>();
        String mens;
        try {
            mens = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        } catch (Exception e) {
            mens = ex.getBindingResult().getFieldErrors().get(0).getField();
        }
        response.put("mensaje", mens);
        return response;
    }
}
