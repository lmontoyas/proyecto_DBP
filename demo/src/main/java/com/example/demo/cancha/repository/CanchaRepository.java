package com.example.demo.cancha.repository;

import com.example.demo.cancha.model.Cancha;
import com.example.demo.complejo.model.Complejo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CanchaRepository extends JpaRepository<Cancha,Long> {

    Cancha findByNombre(String nombre);

    Page<Cancha> findByComplejo(Complejo complejo, Pageable pageable);
}
