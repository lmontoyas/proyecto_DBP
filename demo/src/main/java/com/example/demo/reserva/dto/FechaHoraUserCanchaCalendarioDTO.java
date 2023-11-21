package com.example.demo.reserva.dto;

import com.example.demo.calendario.model.Calendario;
import com.example.demo.cancha.model.Cancha;
import com.example.demo.usuario.model.User;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class FechaHoraUserCanchaCalendarioDTO {
    @NotNull
    private Long id;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private User user;

    @NotNull
    private Cancha cancha;

    @NotNull
    private Calendario calendario;

    public FechaHoraUserCanchaCalendarioDTO() {
    }

    public FechaHoraUserCanchaCalendarioDTO(Long id, LocalDate fecha, User user, Cancha cancha, Calendario calendario) {
        this.id = id;
        this.fecha = fecha;
        this.user = user;
        this.cancha = cancha;
        this.calendario = calendario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }
}
