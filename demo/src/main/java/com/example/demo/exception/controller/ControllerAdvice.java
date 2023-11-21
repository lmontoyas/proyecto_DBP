package com.example.demo.exception.controller;

import com.example.demo.exception.model.ErrorRespuesta;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<ErrorRespuesta> handlerNoSuchElementException(NoSuchElementException exception){
        ErrorRespuesta error = new ErrorRespuesta("P-500", exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRespuesta> handleValidationException(MethodArgumentNotValidException exception) {
        ErrorRespuesta error = new ErrorRespuesta("P-501", "Un dato no ha sido completado");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ErrorRespuesta> handlerDataIntegrityViolationException(DataIntegrityViolationException exception) {
        ErrorRespuesta error = new ErrorRespuesta("P-502", exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
