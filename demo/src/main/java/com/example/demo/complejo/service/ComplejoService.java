package com.example.demo.complejo.service;

import com.example.demo.complejo.dto.DetalleComplejoDTO;
import com.example.demo.proyection.NombreDireccionImagen;
import com.example.demo.complejo.model.Complejo;
import com.example.demo.complejo.repository.ComplejoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ComplejoService {

    @Autowired
    private ComplejoRepository complejoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<NombreDireccionImagen> obtenerNombresDireccionesImagenes(String pais, String provincia, String distrito, Pageable pageable) {
        if (distrito.isEmpty() & !provincia.isEmpty() & !pais.isEmpty()) {
            return complejoRepository.findByPaisAndProvincia(pais, provincia, pageable);
        } else if (distrito.isEmpty() & provincia.isEmpty() & !pais.isEmpty()) {
            return complejoRepository.findByPais(pais, pageable);
        } else if (!distrito.isEmpty() & !provincia.isEmpty() & !pais.isEmpty()) {
            return complejoRepository.findByPaisAndProvinciaAndDistrito(pais, provincia, distrito, pageable);
        } else {
            return complejoRepository.findNombreDireccionImagen(pageable);
        }
    }

    public DetalleComplejoDTO obtenerComplejo(Long id){
        Optional<Complejo> optionalComplejo = complejoRepository.findById(id);
        if(optionalComplejo.isEmpty()){throw new NoSuchElementException("Complejo no se encuentra");}
        Complejo complejo = optionalComplejo.get();
        DetalleComplejoDTO detalleComplejoDTO = modelMapper.map(complejo, DetalleComplejoDTO.class);
        List<String> nombresServicios = complejo.getComplejoServicios()
                .stream()
                .map(cs -> cs.getServicio().getNombre())
                .collect(Collectors.toList());
        detalleComplejoDTO.setServicios(nombresServicios);
        return detalleComplejoDTO;
    }

    public Complejo obtenerComplejoPorId(Long id){
        Optional<Complejo> optionalComplejo = complejoRepository.findById(id);
        if (optionalComplejo.isEmpty()) {
            throw new NoSuchElementException("Complejo no se encuentra");
        }
        return optionalComplejo.get();
    }

    public boolean validarComplejo(Complejo complejo){
        return complejoRepository.existsByNombreAndDireccionAndLatitudAndLongitud(complejo.getNombre(),complejo.getDireccion(), complejo.getLatitud(), complejo.getLongitud());
    }

    public String crearComplejo(Complejo complejo){
        if(validarComplejo(complejo)){throw new DataIntegrityViolationException("Complejo '" + complejo.getNombre() + "' ya existe");}
        complejoRepository.save(complejo);
        return "Created";
    }


    public String crearVariosComplejos(List<Complejo>complejos){
        for (Complejo complejo:complejos) {
            if(validarComplejo(complejo)){throw new DataIntegrityViolationException("Complejo '" + complejo.getNombre() + "' ya existe");}
            complejoRepository.save(complejo);
        }
        return "Created";
    }

    public String modificarComplejo(Long id, Complejo complejo){
        Optional<Complejo> optionalComplejo = complejoRepository.findById(id);
        if(!optionalComplejo.isPresent()){
            throw new NoSuchElementException("Complejo no se encuentra");
        }
        Complejo existingComplejo = optionalComplejo.get();
        existingComplejo.setNombre(complejo.getNombre());
        existingComplejo.setPais(complejo.getPais());
        existingComplejo.setProvincia(complejo.getProvincia());
        existingComplejo.setDistrito(complejo.getDistrito());
        existingComplejo.setDireccion(complejo.getDireccion());
        existingComplejo.setImagen(complejo.getImagen());
        existingComplejo.setLatitud(complejo.getLatitud());
        existingComplejo.setLongitud(complejo.getLongitud());
        complejoRepository.save(existingComplejo);
        return "Created";
    }

    public String eliminarComplejo(Long id){
        Optional<Complejo> optionalComplejo = complejoRepository.findById(id);
        if(!optionalComplejo.isPresent()){
            throw new NoSuchElementException("Complejo no se encuentra");
        }
        complejoRepository.deleteById(id);
        return "Deleted";
    }
}
