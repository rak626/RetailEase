package com.retailease.product.exceptions;


import com.retailease.product.payloads.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, HttpStatus.NO_CONTENT, e.getClass());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }

    @ExceptionHandler(InvalidQuantityException.class)
    public ResponseEntity<ExceptionResponse> InvalidQuantityExceptionHandler(InvalidQuantityException e) {
        String message = e.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message, HttpStatus.NOT_ACCEPTABLE, e.getClass());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }
}
