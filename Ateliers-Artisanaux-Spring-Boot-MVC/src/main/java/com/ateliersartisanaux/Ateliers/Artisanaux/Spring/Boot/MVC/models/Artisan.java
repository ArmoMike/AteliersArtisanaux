package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Artisan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArtisan;
    private String nomArtisan;

    @ManyToOne
    @JoinColumn(name = "idAtelier")
    private Atelier atelier;

    // Getters and setters
    public Long getIdArtisan() {
        return idArtisan;
    }

    public void setIdArtisan(Long idArtisan) {
        this.idArtisan = idArtisan;
    }

    public String getNomArtisan() {
        return nomArtisan;
    }

    public void setNomArtisan(String nomArtisan) {
        this.nomArtisan = nomArtisan;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

}
