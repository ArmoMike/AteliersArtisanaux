package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.CreneauHoraire;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Participant;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByParticipantEmailParticipant(String emailParticipant);
    
    
    List<Reservation> findByParticipantAndCreneauHoraireAndDateDebut(Participant participant, CreneauHoraire creneauHoraire, LocalDate dateDebut);
    }

