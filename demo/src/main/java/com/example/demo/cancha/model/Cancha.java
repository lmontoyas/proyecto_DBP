package com.example.demo.cancha.model;

import com.example.demo.complejo.model.Complejo;
import com.example.demo.reserva.model.Reserva;
import com.example.demo.tipo.model.Tipo;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@Entity
@Table(name = "cancha")
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private Long precioHora;


    private Boolean esActivo;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    @JsonIgnore
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "complejo_id")
    @JsonIgnore
    private Complejo complejo;


    @OneToMany(mappedBy = "cancha")
    @JsonIgnore
    List<Reserva> reservas;


    public Cancha() {
    }

    public Cancha(String nombre, Long precioHora, Tipo tipo, Complejo complejo) {
        this.nombre = nombre;
        this.precioHora = precioHora;
        this.tipo = tipo;
        this.complejo = complejo;
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

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public Long getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Long precioHora) {
        this.precioHora = precioHora;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Complejo getComplejo() {
        return complejo;
    }

    public void setComplejo(Complejo complejo) {
        this.complejo = complejo;
    }

    @JsonIgnore
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}

