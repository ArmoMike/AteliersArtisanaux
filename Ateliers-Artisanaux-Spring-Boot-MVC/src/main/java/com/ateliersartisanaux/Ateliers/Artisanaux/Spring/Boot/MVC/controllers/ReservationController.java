package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.controllers;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Atelier;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.CreneauHoraire;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Participant;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Reservation;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services.AtelierService;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services.CreneauHoraireService;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services.ParticipantService;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services.ReservationService;

import java.util.List;
import java.util.NoSuchElementException;


//Définition du contrôleur pour la gestion des réservations
@Controller
public class ReservationController {

    // Injection de dépendances pour les services nécessaires

    private final ReservationService reservationService;
    private final ParticipantService participantService;
    private final AtelierService atelierService;
    private final CreneauHoraireService creneauHoraireService;

    public ReservationController(ReservationService reservationService, ParticipantService participantService, AtelierService atelierService, CreneauHoraireService creneauHoraireService) {
        this.reservationService = reservationService;
		this.participantService = participantService;
		this.atelierService = atelierService;
		this.creneauHoraireService = creneauHoraireService;
    }
    
 
    @GetMapping("/")
    public String showMainPage() {
        return "mainPage";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/cancel")
    public String showCancelReservationPage() {
        return "cancelReservation";
    }
    
    
    // Affichage du formulaire de réservation

    @GetMapping("/showReservationForm")
    public String showMakeReservationPage(@RequestParam(name = "idParticipant", required = true) Long idParticipant, Model model) {
    	
        // Récupération de la liste des ateliers et des créneaux horaires

    	List<Atelier> ateliers = atelierService.getAllAtelier();
    	List<CreneauHoraire> creneauxHoraire = creneauHoraireService.getAllCreneauHoraire();
    	
        // Création d'un participant avec l'ID spécifié

        Participant participant = new Participant();
        participant.setIdParticipant(idParticipant);
    	
        
        // Ajout des attributs au modèle

        model.addAttribute("idParticipant", idParticipant);
        model.addAttribute("participant", participant); 
        model.addAttribute("ateliers", ateliers);
        model.addAttribute("creneauxHoraire", creneauxHoraire);

        return "showReservationForm";
    }

    // Traitement de la soumission du formulaire de réservation

    @PostMapping("/makeReservation")
    public String makeReservation(@ModelAttribute("reservation") @DateTimeFormat(pattern = "MM/dd/yyyy") Reservation reservation, Model model) {
    	
        // Vérification si le participant est nul et création d'un participant vide si nécessaire

    	  if (reservation.getParticipant() == null) {
    	        reservation.setParticipant(new Participant());
    	    }

          // Vérification de l'unicité de la réservation

        if (reservationService.isReservationUnique(reservation)) {
            // Enregistrement de la réservation

            reservationService.saveReservation(reservation);
            model.addAttribute("confirmationMessage", "Réservation réussie !");
        } else {
            model.addAttribute("error", "La réservation existe déjà pour cet atelier, ce créneau horaire et cette date.");
        }

        // Ajout des attributs au modèle pour afficher à nouveau le formulaire

        model.addAttribute("ateliers", atelierService.getAllAtelier());
        model.addAttribute("creneauxHoraire", creneauHoraireService.getAllCreneauHoraire());

        return "showReservationForm";
    }



    // Affichage de la liste des réservations

    @GetMapping("/reservations")
    public String showReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservations";
    }

    
    // Affichage des réservations d'un participant spécifique

    @GetMapping("/reservations/participant")
    public String getReservationsByParticipant(@RequestParam("email") String email, Model model) {
        if (email == null || email.isEmpty()) {
            return "redirect:/reservations"; // redirect
        }

        
        // Récupération des ateliers, créneaux horaires et réservations du participant

    	List<Atelier> ateliers = atelierService.getAllAtelier();
    	List<CreneauHoraire> creneauxHoraire = creneauHoraireService.getAllCreneauHoraire();
        List<Reservation> reservations = reservationService.getReservationsByParticipantEmail(email);
        
        
        // Récupération du participant par email

        Participant participant = participantService.getParticipantByEmail(email);
        

        // Ajout des attributs au modèle

        model.addAttribute("reservations", reservations);
        model.addAttribute("participant", participant);
        model.addAttribute("ateliers", ateliers);
        model.addAttribute("creneauxHoraire", creneauxHoraire);

        return "reservationsByParticipant"; // le nom de la vue Thymeleaf
    }
    
    
    // Suppression d'une réservation par ID

    @PostMapping("/reservations/delete")
    public String deleteReservation(@RequestParam("reservationId") Long reservationId) {
        if (reservationId == null) {
          
            return "redirect:/reservations"; 
        }
        String email = "";
        Reservation reservation = reservationService.getReservationById(reservationId);
            email = reservation.getParticipant().getEmailParticipant();
            
        reservationService.deleteReservationById(reservationId);
     
        

        return "redirect:/reservations/participant?email=" + email;

    }
    @PostMapping("/reservations/deleteById") 
    public String deleteReservationById(@RequestParam("ID") Long reservationId, Model model) {
        try {
            reservationService.deleteReservationById(reservationId);

            model.addAttribute("confirmationMessage", "La réservation " + reservationId + " a été annulée avec succès.");
        } catch (NoSuchElementException e) {
            model.addAttribute("confirmationMessage", "La réservation avec l'ID " + reservationId + " n'existe pas.");
        }

        return "cancelReservation";
    }
}

