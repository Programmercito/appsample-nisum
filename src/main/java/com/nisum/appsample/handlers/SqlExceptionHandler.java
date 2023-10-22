package com.nisum.appsample.handlers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.sql.SQLException;

/**
 *
 * @author programmercito
 */
@ControllerAdvice
public class SqlExceptionHandler {

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, String> handleSQLExceptionñ(SQLException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Error Inesperado en la base de datos");
        return response;
    }
}
