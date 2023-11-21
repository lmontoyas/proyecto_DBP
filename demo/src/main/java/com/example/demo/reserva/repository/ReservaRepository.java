package com.example.demo.reserva.repository;

import com.example.demo.calendario.model.Calendario;
import com.example.demo.cancha.model.Cancha;
import com.example.demo.reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public interface ReservaRepository extends JpaRepository<Reserva,Long>{

    boolean existsByCanchaAndFechaAndCalendario(Cancha cancha, LocalDate fecha, Calendario calendario);
}
