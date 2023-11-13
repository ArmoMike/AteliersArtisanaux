package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.CreneauHoraire;

@Repository
public interface CreneauHoraireRepository extends JpaRepository<CreneauHoraire, Long> {

}
