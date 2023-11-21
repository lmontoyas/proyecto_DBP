package com.example.demo.reserva.service;

import com.example.demo.calendario.model.Calendario;
import com.example.demo.cancha.model.Cancha;
import com.example.demo.cancha.service.CanchaService;
import com.example.demo.complejo.model.Complejo;
import com.example.demo.reserva.dto.FechaHoraUserCanchaCalendarioDTO;
import com.example.demo.reserva.model.Reserva;
import com.example.demo.reserva.repository.ReservaRepository;
import com.example.demo.usuario.model.User;
import com.example.demo.usuario.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CanchaService canchaService;

    @Autowired
    private UserService userService;

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerReservaPorId(Long id) {
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        return optionalReserva.orElse(null);
    }

    public List<Reserva> obtenerDetallesReservasUsuario(Long userId) {
        User user = userService.getOneUser(userId);
        List<Reserva> reservas = reservaRepository.findByUser(user);
        return reservas;
    }

    public boolean validarReserva(Cancha cancha, LocalDate fecha, Calendario calendario){
        return reservaRepository.existsByCanchaAndFechaAndCalendario(cancha, fecha, calendario);
    }

    public String guardarReserva(FechaHoraUserCanchaCalendarioDTO fechaHoraUserCanchaCalendarioDTO) {
        if(validarReserva(fechaHoraUserCanchaCalendarioDTO.getCancha(), fechaHoraUserCanchaCalendarioDTO.getFecha(), fechaHoraUserCanchaCalendarioDTO.getCalendario())){throw new DataIntegrityViolationException("Cancha ya está reservada en este horario");}
        Reserva reserva = modelMapper.map(fechaHoraUserCanchaCalendarioDTO, Reserva.class);
        Cancha cancha = canchaService.obtenerCancha(fechaHoraUserCanchaCalendarioDTO.getCancha().getId());
        reserva.setMontoTotal(cancha.getPrecioHora());
        reservaRepository.save(reserva);
        return "Created";
    }

    public Reserva actualizarReserva(Long id, Reserva reserva) {
        if (reservaRepository.existsById(id)) {
            return reservaRepository.save(reserva);
        } else {
            return null;
        }
    }

    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    // Otros métodos según sea necesario

}
