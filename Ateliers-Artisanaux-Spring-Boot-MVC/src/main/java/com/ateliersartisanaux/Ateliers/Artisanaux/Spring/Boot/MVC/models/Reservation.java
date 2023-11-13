package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models;

import java.time.LocalDate; 

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Long idReservation;
    
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateDebut;
    
    @ManyToOne
    @JoinColumn(name = "idAtelier")
    private Atelier atelier;
    
    @ManyToOne
    @JoinColumn(name = "idParticipant")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "idCreneau")
    private CreneauHoraire creneauHoraire;
    
    // getters and setters
    
    public CreneauHoraire getCreneauHoraire() {
		return creneauHoraire;
	}

	public void setCreneauHoraire(CreneauHoraire creneauHoraire) {
		this.creneauHoraire = creneauHoraire;
	}

	public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
