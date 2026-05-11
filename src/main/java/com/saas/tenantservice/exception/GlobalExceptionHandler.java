package com.saas.tenantservice.exception;

import java.util.HashMap;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HashMap<String, String> handleValidation(MethodArgumentNotValidException ex){
        HashMap<String, String> error = new HashMap<>();
        ex.getBindingResult().getFieldErrors().
        forEach(err ->{
            error.put(err.getField(), err.getDefaultMessage());
        });
        return error;
    }

}
