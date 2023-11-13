package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.CreneauHoraire;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Participant;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Reservation;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.ReservationTracker;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
   // private final ReservationTracker reservationTracker;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationTracker reservationTracker) {
        this.reservationRepository = reservationRepository;
  //      this.reservationTracker = reservationTracker;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

  public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    } 

	public List<Reservation> getReservationsByParticipantEmail(String emailParticipant) {
        return reservationRepository.findByParticipantEmailParticipant(emailParticipant);

	}
	public boolean isReservationUnique(Reservation reservation) {
	    // Accédez aux propriétés nécessaires des objets liés (participant et creneauHoraire)
	    Participant participant = reservation.getParticipant();
	    CreneauHoraire creneauHoraire = reservation.getCreneauHoraire();

	    // Vérifiez si une réservation avec les mêmes valeurs pour participant, creneauHoraire et dateDebut existe déjà
	    List<Reservation> existingReservations = reservationRepository.findByParticipantAndCreneauHoraireAndDateDebut(participant, creneauHoraire, reservation.getDateDebut());
	    return existingReservations.isEmpty();
	}

}
