package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.Artisan;
import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.services.ArtisanService;


@Controller
public class ArtisanController {
	private final ArtisanService artisanService ;
	
	public ArtisanController(ArtisanService artisanService) {
		this.artisanService = artisanService;
	}
	
    @GetMapping("/artisans")
    public String showArtisans(Model model) {
        List<Artisan> artisans = artisanService.getAllArtisans();
        model.addAttribute("artisans", artisans);
        return "artisans";
    }

}
