package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Atelier;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.repository.AtelierRepository;

@Service
public class AtelierService {

	private final AtelierRepository atelierRepository;
	
	@Autowired
	public AtelierService(AtelierRepository atelierRepository) {
		this.atelierRepository = atelierRepository;
	}

	    public List<Atelier> getAllAtelier() {
	        return atelierRepository.findAll();
	    }

	    public Atelier getAtelierById(Long id) {
	        return atelierRepository.findById(id).orElse(null);
	    }

	    public void saveAtelier(Atelier atelier) {
	    	atelierRepository.save(atelier);
	    }

	    public void deleteArtisan(Long id) {
	    	atelierRepository.deleteById(id);
	    }
	}

