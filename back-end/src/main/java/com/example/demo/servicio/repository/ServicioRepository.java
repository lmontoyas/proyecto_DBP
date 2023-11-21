package com.example.demo.servicio.repository;

import com.example.demo.servicio.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Long> {

    boolean existsByNombre(String nombre);

    @Query("SELECT s.nombre FROM Servicio s WHERE s.id = :id")
    String findNombreById(Long id);
}
