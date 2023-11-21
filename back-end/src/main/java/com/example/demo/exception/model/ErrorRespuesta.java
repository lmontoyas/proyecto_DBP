package com.example.demo.exception.model;

import org.springframework.web.bind.annotation.ResponseStatus;

public class ErrorRespuesta {

    private String codigo;

    private String mensaje;

    public ErrorRespuesta() {
    }

    public ErrorRespuesta(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
