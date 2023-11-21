package com.example.demo.complejo.repository;

import com.example.demo.complejo.model.Complejo;
import com.example.demo.proyection.NombreDireccionImagen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplejoRepository extends JpaRepository<Complejo,Long> {

    @Query("SELECT c.id AS id, c.nombre AS nombre, c.direccion AS direccion, c.imagen AS imagen FROM Complejo c")
    Page<NombreDireccionImagen> findNombreDireccionImagen(Pageable pageable);

    Page<NombreDireccionImagen> findByPaisAndProvinciaAndDistrito(String pais, String provincia, String distrito, Pageable pageable);

    Page<NombreDireccionImagen> findByPaisAndProvincia(String pais, String provincia, Pageable pageable);

    Page<NombreDireccionImagen> findByPais(String pais, Pageable pageable);

    @Query("SELECT c.nombre FROM Complejo c WHERE c.id = :id")
    String findNombreById(Long id);

    boolean existsByNombreAndDireccionAndLatitudAndLongitud(String nombre, String direccion, String latitud, String longitud);

}
