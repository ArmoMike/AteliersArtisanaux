package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Atelier;

@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Long> {

    List<Atelier> findByIdAtelier(String idAtelier);

    Atelier findByNomAtelier(String nomAtelier);

}
