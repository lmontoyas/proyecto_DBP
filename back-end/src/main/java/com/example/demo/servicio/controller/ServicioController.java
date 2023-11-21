package com.example.demo.servicio.controller;

import com.example.demo.servicio.model.Servicio;
import com.example.demo.servicio.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<Servicio>> servicios(){
        return new ResponseEntity<>(servicioService.TraerServicios(), HttpStatus.OK);
    }

    @PostMapping
    @Secured("ADMIN")
    public ResponseEntity<String> crearServicio(@RequestBody List<Servicio> servicios){
        return new ResponseEntity<>(servicioService.crearServicios(servicios),HttpStatus.ACCEPTED);
    }
}
