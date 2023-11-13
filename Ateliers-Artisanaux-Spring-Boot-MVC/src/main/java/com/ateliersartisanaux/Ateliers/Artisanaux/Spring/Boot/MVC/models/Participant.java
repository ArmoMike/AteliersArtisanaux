package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParticipant;

    private String nomParticipant;
    
    @Column(name = "emailParticipant")
    private String emailParticipant;

    @OneToMany(mappedBy = "participant")
    private List<Reservation> reservations;

    // Getters and setters
	public Long getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(Long idParticipant) {
		this.idParticipant = idParticipant;
	}

	public String getNomParticipant() {
		return nomParticipant;
	}

	public void setNomParticipant(String nomParticipant) {
		this.nomParticipant = nomParticipant;
	}

	public String getEmailParticipant() {
		return emailParticipant;
	}

	public void setEmailParticipant(String emailParticipant) {
		this.emailParticipant = emailParticipant;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
