package com.example.demo.cancha.service;

import com.example.demo.cancha.dto.NombrePrecioHoraComplejoTipoDTO;
import com.example.demo.cancha.dto.NombrePrecioHoraEstadoDTO;
import com.example.demo.cancha.model.Cancha;
import com.example.demo.cancha.repository.CanchaRepository;
import com.example.demo.complejo.dto.DetalleComplejoDTO;
import com.example.demo.complejo.model.Complejo;
import com.example.demo.complejo.service.ComplejoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CanchaService {

    @Autowired
    private CanchaRepository canchaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ComplejoService complejoService;

    public Page<Cancha> obtenerTodasLasCanchasPorComplejo(Long complejoId, Pageable pageable){
        Complejo complejo = complejoService.obtenerComplejoPorId(complejoId);
        return canchaRepository.findByComplejo(complejo, pageable);
    }

    public NombrePrecioHoraEstadoDTO obtenerCancha(String nombre){
        Cancha cancha = canchaRepository.findByNombre(nombre);
        if(cancha == null){
            throw new NoSuchElementException("Cancha no se encuentra");
        }
        NombrePrecioHoraEstadoDTO nombrePrecioHoraTipoComplejoDTO = modelMapper.map(cancha, NombrePrecioHoraEstadoDTO.class);
        return nombrePrecioHoraTipoComplejoDTO;
    }

    public Cancha obtenerCancha(Long id){
        Optional<Cancha> optionalCancha = canchaRepository.findById(id);
        return optionalCancha.get();
    }

    public String crearCancha(NombrePrecioHoraComplejoTipoDTO nombrePrecioHoraComplejoTipoDTO) {
        Cancha cancha = modelMapper.map(nombrePrecioHoraComplejoTipoDTO, Cancha.class);
        cancha.setEsActivo(true);
        canchaRepository.save(cancha);
        return "Created";
    }

    public String modificarEstadoCancha(String nombre, Cancha cancha){
        Cancha canchaExistente = canchaRepository.findByNombre(nombre);
        if(cancha == null){
            throw new NoSuchElementException("Cancha no se encuentra");
        }
        canchaExistente.setEsActivo(cancha.getEsActivo());
        return "Edited";
    }

    public String eliminarCancha(Long id){
        Optional<Cancha> cancha = canchaRepository.findById(id);
        if(!cancha.isPresent()){
            throw new NoSuchElementException("Cancha no se encuentra");
        }
        canchaRepository.deleteById(id);
        return "Deleted";
    }
}
