package com.avd.jdmrest.controller;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
abstract class AbstractController {
    String prefix = "[REQUEST] ";

    /**
     * Log the controller which is called
     *
     * @param message message to log
     */
    public void log(String message) {
        System.out.println(prefix + message);
    }

    /**
     * Log the controller which is called with id
     *
     * @param message message to log
     * @param id     id to log
     */
    public void log(String message, Long id) {
        System.out.println(prefix + message + " " + id);
    }

    /**
     * Handle validation errors
     * @param ex MethodArgumentNotValidException
     * @return Map<String, String>
     */
    public Map<String, String> handleErrors(MethodArgumentNotValidException ex) {
        log("Errors to be handled");
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
