package com.example.demo.complejo.controller;

import com.example.demo.complejo.dto.DetalleComplejoDTO;
import com.example.demo.complejo.model.Complejo;
import com.example.demo.complejo.service.ComplejoService;
import com.example.demo.proyection.NombreDireccionImagen;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complejo")
public class ComplejoController {

    @Autowired
    private ComplejoService complejoService;

    @GetMapping
    public ResponseEntity<Page<NombreDireccionImagen>> obtenerNombresDireccionesImagenes(@RequestParam String pais, @RequestParam String provincia, @RequestParam String distrito, @PageableDefault Pageable pageable) {
        Page<NombreDireccionImagen> nombresDireccionesImagenes = complejoService.obtenerNombresDireccionesImagenes(pais, provincia, distrito, pageable);
        return ResponseEntity.ok(nombresDireccionesImagenes);
    }

    @GetMapping("/detalle")
    public ResponseEntity<DetalleComplejoDTO> traerComplejo(@RequestParam Long id){
        return new ResponseEntity<>(complejoService.obtenerComplejo(id), HttpStatus.OK);
    }

    @PostMapping
    @Secured("ADMIN")
    public ResponseEntity<String> crearComplejos(@Valid @RequestBody List<Complejo> complejos){
        return new ResponseEntity<>(complejoService.crearVariosComplejos(complejos),HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity<String> editarComplejo(@PathVariable Long id, @RequestBody Complejo complejo){
        return new ResponseEntity<>(complejoService.modificarComplejo(id, complejo),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity<String> destruirComplejo(@PathVariable Long id){
        return new ResponseEntity<>(complejoService.eliminarComplejo(id),HttpStatus.OK);
    }
}

