package com.example.demo.servicio.service;

import com.example.demo.servicio.model.Servicio;
import com.example.demo.servicio.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> TraerServicios(){
        return servicioRepository.findAll();
    }

    public boolean validarServicio(Servicio servicio){
        return servicioRepository.existsByNombre(servicio.getNombre());
    }

    public String crearServicio(Servicio servicio){
        if(validarServicio(servicio)){throw new DataIntegrityViolationException("Servicio '" + servicio.getNombre() + "' ya existe");}
        servicioRepository.save(servicio);
        return "Created";
    }
    public String crearServicios(List<Servicio>servicios){
        for (Servicio servicio:servicios) {
            if(validarServicio(servicio)){throw new DataIntegrityViolationException("Servicio '" + servicio.getNombre() + "' ya existe");}
            servicioRepository.save(servicio);
        }
        return "Created";
    }

}
