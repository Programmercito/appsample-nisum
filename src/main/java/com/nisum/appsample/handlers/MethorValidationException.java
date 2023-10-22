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
 *
 * @author programmercito
 */
@ControllerAdvice

public class MethorValidationException {

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
