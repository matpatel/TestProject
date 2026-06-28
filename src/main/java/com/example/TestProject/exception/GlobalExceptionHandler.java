package com.example.TestProject.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {

        System.out.println("✅ HANDLER HIT");  // debug

        return new ResponseEntity<>(
                new ErrorResponse("NOT_FOUND", ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {

        return new ResponseEntity<>(
                new ErrorResponse("INTERNAL_ERROR", "Something went wrong"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
