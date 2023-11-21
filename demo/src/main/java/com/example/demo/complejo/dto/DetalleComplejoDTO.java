package com.example.demo.complejo.dto;
import com.example.demo.cancha.model.Cancha;
import com.example.demo.complejo.model.Complejo;
import com.example.demo.complejo_servicio.model.ComplejoServicio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.stream.Collectors;

public class DetalleComplejoDTO {

    private String Nombre;

    private String Direccion;

    private String Imagen;

    private String latitud;

    private String longitud;

    private List<Cancha> canchas;

    private List<String> servicios;

    public DetalleComplejoDTO() {}

    public DetalleComplejoDTO(String nombre, String direccion, String imagen, String latitud, String longitud, List<Cancha> canchas, List<String> servicios) {
        Nombre = nombre;
        Direccion = direccion;
        Imagen = imagen;
        this.latitud = latitud;
        this.longitud = longitud;
        this.canchas = canchas;
        this.servicios = servicios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public List<Cancha> getCanchas() {
        return canchas;
    }

    public void setCanchas(List<Cancha> canchas) {
        this.canchas = canchas;
    }

    public List<String> getServicios() {
        return servicios;
    }

    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
    }
}
