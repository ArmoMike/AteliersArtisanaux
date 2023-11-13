package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Artisan;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.repository.ArtisanRepository;

import java.util.List;

@Service
public class ArtisanService {

    private final ArtisanRepository artisanRepository;

    @Autowired
    public ArtisanService(ArtisanRepository artisanRepository) {
        this.artisanRepository = artisanRepository;
    }

    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }

    public Artisan getArtisanById(Long id) {
        return artisanRepository.findById(id).orElse(null);
    }

    public void saveArtisan(Artisan artisan) {
        artisanRepository.save(artisan);
    }

    public void deleteArtisan(Long id) {
        artisanRepository.deleteById(id);
    }
}
