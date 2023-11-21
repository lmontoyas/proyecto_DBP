package com.example.demo.calendario.model;

import com.example.demo.reserva.model.Reserva;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name="calendario")
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String dia;

    @NotNull
    private Time hora;

    @OneToMany(mappedBy = "calendario")
    private List<Reserva> reservas;

    public Calendario() {
    }

    public Calendario(String dia, Time hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
