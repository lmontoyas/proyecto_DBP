package com.example.demo.usuario.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SignUpDTO {

    @Email(message = "Email no valido")
    @NotBlank(message = "Email nulo o en blanco")
    private String email;

    @NotBlank(message = "Contraseña no valida")
    private String password;

    private Long phone;

    public SignUpDTO() {
    }

    public SignUpDTO(String email, String password, Long phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
