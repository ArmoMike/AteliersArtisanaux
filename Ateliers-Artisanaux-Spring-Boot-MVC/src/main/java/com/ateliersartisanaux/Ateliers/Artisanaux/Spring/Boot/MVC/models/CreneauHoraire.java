package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CreneauHoraire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCreneau;

    private String nomCreneau;
    
    @ManyToOne
    @JoinColumn(name = "idAtelier")
    private Atelier atelier;

    // Getters and setters

    public Long getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(Long idCreneau) {
        this.idCreneau = idCreneau;
    }

    public String getNomCreneau() {
        return nomCreneau;
    }

    public void setNomCreneau(String nomCreneau) {
        this.nomCreneau = nomCreneau;
    }
}
