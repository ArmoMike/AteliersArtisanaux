package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models.ReservationTracker;

@Configuration
public class AppConfig {

    @Bean
    public ReservationTracker reservationTracker() {
        return new ReservationTracker();
    }
}
