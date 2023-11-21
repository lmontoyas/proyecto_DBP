package com.example.demo.complejo_servicio.repository;

import com.example.demo.complejo.model.Complejo;
import com.example.demo.complejo_servicio.model.ComplejoServicio;
import com.example.demo.servicio.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplejoServicioRepository extends JpaRepository<ComplejoServicio, Long> {

    boolean existsByComplejoAndAndServicio(Complejo complejo, Servicio servicio);
}
