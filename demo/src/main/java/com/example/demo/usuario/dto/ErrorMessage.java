package com.example.demo.usuario.dto;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    public String message;

    public HttpStatus httpStatus;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
