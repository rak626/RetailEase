package com.retailease.customer.exceptions;


import com.retailease.customer.payload.response.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {

        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, HttpStatus.NO_CONTENT, e.getClass());
        logger.info("Resource not found exception occurred---- \n, {}, \n {}", message, e.getClass());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }
}
