package com.example.demo.complejo_servicio.service;

import com.example.demo.complejo.model.Complejo;
import com.example.demo.complejo.repository.ComplejoRepository;
import com.example.demo.complejo.service.ComplejoService;
import com.example.demo.complejo_servicio.model.ComplejoServicio;
import com.example.demo.complejo_servicio.repository.ComplejoServicioRepository;
import com.example.demo.exception.model.DataIntegrityViolationException;
import com.example.demo.servicio.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplejoServicioService {

    @Autowired
    ComplejoServicioRepository complejoServicioRepository;

    @Autowired
    ComplejoRepository complejoRepository;

    @Autowired
    ServicioRepository servicioRepository;

    public boolean validarComplejoServicio(ComplejoServicio complejoServicio){
        return complejoServicioRepository.existsByComplejoAndAndServicio(complejoServicio.getComplejo(),complejoServicio.getServicio());
    }

    public String traerNombre(ComplejoServicio complejoServicio){
        Long complejoId = complejoServicio.getComplejo().getId();
        String nombreComplejo = complejoRepository.findNombreById(complejoId);
        return nombreComplejo;
    }

    public String traerServicio(ComplejoServicio complejoServicio){
        Long servicioId = complejoServicio.getServicio().getId();
        String nombreServicio = servicioRepository.findNombreById(servicioId);
        return nombreServicio;
    }

    public String crearRelacionComplejoServicio(List<ComplejoServicio> complejoServicioList){
        for (ComplejoServicio complejoServicio: complejoServicioList) {
            if (validarComplejoServicio(complejoServicio)){throw new DataIntegrityViolationException("Complejo " + traerNombre(complejoServicio) + " ya tiene el servicio de " + traerServicio(complejoServicio) );}
            complejoServicioRepository.save(complejoServicio);
        }
        return "Created";
    }
}
