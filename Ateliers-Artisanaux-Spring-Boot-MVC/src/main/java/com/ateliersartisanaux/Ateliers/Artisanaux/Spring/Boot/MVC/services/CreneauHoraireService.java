package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.CreneauHoraire;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.repository.CreneauHoraireRepository;

@Service
public class CreneauHoraireService {

	private final CreneauHoraireRepository creneauHoraireRepository;
	
	@Autowired
	public CreneauHoraireService(CreneauHoraireRepository creneauHoraireRepository) {
		this.creneauHoraireRepository = creneauHoraireRepository;
	}

    public List<CreneauHoraire> getAllCreneauHoraire() {
        return creneauHoraireRepository.findAll();
    }

    public CreneauHoraire getCreneauHoraireById(Long id) {
        return creneauHoraireRepository.findById(id).orElse(null);
    }

    public void saveCreneauHoraire(CreneauHoraire creneauHoraire) {
    	creneauHoraireRepository.save(creneauHoraire);
    }

    public void deleteCreneauHoraire(Long id) {
    	creneauHoraireRepository.deleteById(id);
    }
}
