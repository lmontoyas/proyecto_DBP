package com.example.demo.reserva.controller;

import com.example.demo.reserva.dto.FechaHoraUserCanchaCalendarioDTO;
import com.example.demo.reserva.model.Reserva;
import com.example.demo.reserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerTodasLasReservas() {
        List<Reserva> reservas = reservaService.obtenerTodasLasReservas();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crearReserva(@RequestBody FechaHoraUserCanchaCalendarioDTO fechaHoraUserCanchaCalendarioDTO) {
        return new ResponseEntity<>(reservaService.guardarReserva(fechaHoraUserCanchaCalendarioDTO), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva reservaActualizada = reservaService.actualizarReserva(id, reserva);
        if (reservaActualizada != null) {
            return ResponseEntity.ok(reservaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }

    // Otros métodos según sea necesario

}
