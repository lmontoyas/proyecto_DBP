package com.example.demo.cancha.controller;

import com.example.demo.cancha.dto.NombrePrecioHoraComplejoTipoDTO;
import com.example.demo.cancha.dto.NombrePrecioHoraEstadoDTO;
import com.example.demo.cancha.model.Cancha;
import com.example.demo.cancha.service.CanchaService;
import com.example.demo.complejo.model.Complejo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cancha")
public class CanchaController {

    @Autowired
    private CanchaService canchaService;

    @GetMapping
    public ResponseEntity<Page<Cancha>> traerTodasLasCanchas(@RequestParam Long id, @PageableDefault Pageable pageable){
        return new ResponseEntity<>(canchaService.obtenerTodasLasCanchasPorComplejo(id, pageable), HttpStatus.OK);
    }

    @PostMapping
    @Secured("ADMIN")
    public ResponseEntity<String> crearCancha(@Valid @RequestBody NombrePrecioHoraComplejoTipoDTO nombrePrecioHoraComplejoTipoDTO){
        return new ResponseEntity<>(canchaService.crearCancha(nombrePrecioHoraComplejoTipoDTO),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{nombre}")
    @Secured("ADMIN")
    public ResponseEntity<String> editarEstadoCancha(@PathVariable String nombre, @RequestBody Cancha cancha){
        return new ResponseEntity<>(canchaService.modificarEstadoCancha(nombre, cancha),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity<String> destruirComplejo(@PathVariable Long id){
        return new ResponseEntity<>(canchaService.eliminarCancha(id),HttpStatus.OK);
    }

}

