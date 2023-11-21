package com.example.demo.complejo_servicio.model;

import com.example.demo.complejo.model.Complejo;
import com.example.demo.servicio.model.Servicio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "complejo_servicio")
public class ComplejoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "complejo_id")
    private Complejo complejo;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    public ComplejoServicio() {
    }

    public ComplejoServicio(Complejo complejo, Servicio servicio) {
        this.complejo = complejo;
        this.servicio = servicio;
    }

    public Complejo getComplejo() {return complejo;}

    public void setComplejo(Complejo complejo) {
        this.complejo = complejo;
    }

    public Servicio getServicio() {return servicio;}

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
