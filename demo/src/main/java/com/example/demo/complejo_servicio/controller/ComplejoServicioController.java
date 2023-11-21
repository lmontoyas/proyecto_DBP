package com.example.demo.complejo_servicio.controller;

import com.example.demo.complejo.model.Complejo;
import com.example.demo.complejo_servicio.model.ComplejoServicio;
import com.example.demo.complejo_servicio.service.ComplejoServicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/complejo_servicio")
public class ComplejoServicioController {

    @Autowired
    private ComplejoServicioService complejoServicioService;

    @PostMapping
    @Secured("ADMIN")
    public ResponseEntity<String> crearComplejos(@RequestBody List<ComplejoServicio> complejoServicioList){
        return new ResponseEntity<>(complejoServicioService.crearRelacionComplejoServicio(complejoServicioList), HttpStatus.ACCEPTED);
    }
}
