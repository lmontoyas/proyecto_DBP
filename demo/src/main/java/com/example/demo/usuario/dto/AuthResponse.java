package com.example.demo.usuario.dto;

public class AuthResponse {

    private String token;
    private String message;
    private Long id;

    public AuthResponse() {
    }

    public AuthResponse(String token, String message, Long id) {
        this.token = token;
        this.message = message;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
