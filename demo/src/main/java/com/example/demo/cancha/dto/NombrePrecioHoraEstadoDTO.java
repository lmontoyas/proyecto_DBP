package com.example.demo.cancha.dto;

public class NombrePrecioHoraEstadoDTO {

    private String nombre;

    private Long precioHora;

    private Boolean esActivo;

    public NombrePrecioHoraEstadoDTO() {
    }

    public NombrePrecioHoraEstadoDTO(String nombre, Long precioHora, Boolean esActivo) {
        this.nombre = nombre;
        this.precioHora = precioHora;
        this.esActivo = esActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Long precioHora) {
        this.precioHora = precioHora;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }
}
