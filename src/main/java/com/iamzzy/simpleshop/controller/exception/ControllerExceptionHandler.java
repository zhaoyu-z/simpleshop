package com.iamzzy.simpleshop.controller.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    // for request parameters validation
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
                    String invalidPropertyPath = violation.getPropertyPath().toString();
                    String invalidValue = violation.getInvalidValue().toString();
                    String invalidProperty =
                            invalidPropertyPath.contains(".") ?
                                    invalidPropertyPath.split("\\.")[1] :
                                    invalidPropertyPath;
                    errors.put(invalidProperty + " " + invalidValue, violation.getMessage());
                }
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // for general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGlobalException(Exception ex) {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("error class", ex.getClass().getName());
        response.put("error message", ex.getMessage());
        response.put("error stacktrace", Arrays.toString(ex.getStackTrace()));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
