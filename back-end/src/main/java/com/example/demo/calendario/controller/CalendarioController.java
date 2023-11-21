package com.example.demo.calendario.controller;

import com.example.demo.calendario.model.Calendario;
import com.example.demo.calendario.service.CalendarioService;
import com.example.demo.servicio.model.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @GetMapping
    public ResponseEntity<List<Calendario>> calendarios(){
        return new ResponseEntity<>(calendarioService.traerCalendarios(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> crearCalendarios(List<Calendario>calendarios){
        return new ResponseEntity<>(calendarioService.crearCalendario(calendarios),HttpStatus.ACCEPTED);
    }
}
