package com.example.demo.tipo.controller;

import com.example.demo.servicio.model.Servicio;
import com.example.demo.tipo.model.Tipo;
import com.example.demo.tipo.service.TipoService;
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
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    TipoService tipoService;

    @PostMapping
    @Secured("ADMIN")
    public ResponseEntity<String> crearServicio(@RequestBody List<Tipo> tipos){
        return new ResponseEntity<>(tipoService.crearTipos(tipos), HttpStatus.ACCEPTED);
    }
}
