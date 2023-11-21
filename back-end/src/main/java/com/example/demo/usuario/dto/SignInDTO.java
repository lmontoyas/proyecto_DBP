package com.example.demo.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SignInDTO {
    @Email(message = "Email no valido")
    @NotBlank(message = "Email nulo o en blanco")
    private String email;
    @NotBlank(message = "Contraseña no valida")
    private String password;

    public SignInDTO() {
    }

    public SignInDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
