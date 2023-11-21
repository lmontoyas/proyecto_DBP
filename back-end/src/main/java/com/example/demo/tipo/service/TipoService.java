package com.example.demo.tipo.service;

import com.example.demo.servicio.model.Servicio;
import com.example.demo.tipo.model.Tipo;
import com.example.demo.tipo.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    @Autowired
    TipoRepository tipoRepository;

    public String crearTipos(List<Tipo> tipos){
        for (Tipo tipo:tipos) {
            tipoRepository.save(tipo);
        }
        return "Created";
    }
}
