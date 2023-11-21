package com.example.demo.cancha.dto;

import com.example.demo.complejo.model.Complejo;
import com.example.demo.tipo.model.Tipo;
import jakarta.validation.constraints.NotNull;

public class NombrePrecioHoraComplejoTipoDTO {

    @NotNull
    private String nombre;

    @NotNull
    private String precioHora;

    @NotNull
    private Complejo complejo;

    @NotNull
    private Tipo tipo;

    public NombrePrecioHoraComplejoTipoDTO() {
    }

    public NombrePrecioHoraComplejoTipoDTO(String nombre, String precioHora, Complejo complejo, Tipo tipo) {
        this.nombre = nombre;
        this.precioHora = precioHora;
        this.complejo = complejo;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(String precioHora) {
        this.precioHora = precioHora;
    }

    public Complejo getComplejo() {
        return complejo;
    }

    public void setComplejo(Complejo complejo) {
        this.complejo = complejo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
