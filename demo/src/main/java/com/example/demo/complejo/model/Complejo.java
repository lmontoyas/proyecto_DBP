package com.example.demo.complejo.model;

import com.example.demo.cancha.model.Cancha;
import com.example.demo.complejo_servicio.model.ComplejoServicio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "complejo")
public class Complejo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String pais;

    @NotNull
    private String provincia;

    @NotNull
    private String distrito;

    @NotNull
    private String direccion;

    @NotNull
    private String imagen;

    @NotNull
    private String latitud;


    @NotNull
    private String longitud;

    @OneToMany(mappedBy = "complejo")
    List<ComplejoServicio> complejoServicios;

    @OneToMany(mappedBy = "complejo")
    List<Cancha> canchas;

    public Complejo() {
    }

    public Complejo(String nombre, String pais, String provincia, String distrito, String direccion, String imagen, String latitud, String longitud) {
        this.nombre = nombre;
        this.pais = pais;
        this.provincia = provincia;
        this.distrito = distrito;
        this.direccion = direccion;
        this.imagen = imagen;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    @JsonIgnore
    public List<ComplejoServicio> getComplejoServicios() {
        return complejoServicios;
    }

    public void setComplejoServicios(List<ComplejoServicio> complejoServicios) {
        this.complejoServicios = complejoServicios;
    }
}
