package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Participant;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.repository.ParticipantRepository;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant getParticipantByEmail(String email) {
        return participantRepository.findByEmailParticipant(email);
    }
}
