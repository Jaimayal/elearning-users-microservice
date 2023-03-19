package com.jaimayal.usersmicroservice.exception;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
    
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserExceptionHandler.class);
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex) {
        LOGGER.info(ex.getMessage());
        return ResponseEntity.notFound().build();
    }
}
