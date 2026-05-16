package com.saas.tenantservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.saas.tenantservice.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Map<String, String>> handleValidation(MethodArgumentNotValidException ex){
        Map<String, String> error = new HashMap<>();
        ex.getBindingResult().getFieldErrors().
        forEach(err ->{
            error.put(err.getField(), err.getDefaultMessage());
        });
        return new ApiResponse<>("Failure", error, "Validation failed");
    }

}
