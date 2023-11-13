package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Atelier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtelier;
    private String nomAtelier;
    private Integer nombreMaxParticipants;

    @OneToMany(mappedBy = "atelier")
    private List<CreneauHoraire> creneauxHoraires;

    // Getters and setters
	public Long getIdAtelier() {
		return idAtelier;
	}
	public void setIdAtelier(Long idAtelier) {
		this.idAtelier = idAtelier;
	}
	public String getNomAtelier() {
		return nomAtelier;
	}
	public void setNomAtelier(String nomAtelier) {
		this.nomAtelier = nomAtelier;
	}
	public Integer getNombreMaxParticipants() {
		return nombreMaxParticipants;
	}
	public void setNombreMaxParticipants(Integer nombreMaxParticipants) {
		this.nombreMaxParticipants = nombreMaxParticipants;
	}
	
}
