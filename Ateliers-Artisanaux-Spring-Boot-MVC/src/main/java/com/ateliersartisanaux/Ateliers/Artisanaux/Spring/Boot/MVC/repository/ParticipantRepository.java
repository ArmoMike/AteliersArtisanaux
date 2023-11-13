package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findByEmailParticipant(String email);
}