package com.example.demo.calendario.service;

import com.example.demo.calendario.model.Calendario;
import com.example.demo.calendario.repository.CalendarioRepository;
import com.example.demo.servicio.model.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioService {

    @Autowired
    CalendarioRepository calendarioRepository;

    public List<Calendario> traerCalendarios(){
        return calendarioRepository.findAll();
    }

    public String crearCalendario(List<Calendario>calendarios){
        for (Calendario calendario: calendarios) {
            calendarioRepository.save(calendario);
        }
        return "Created";
    }
}
