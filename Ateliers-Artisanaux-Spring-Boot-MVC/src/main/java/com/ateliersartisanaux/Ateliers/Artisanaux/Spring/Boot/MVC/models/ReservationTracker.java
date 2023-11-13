package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC.models;

import java.util.HashMap;
import java.util.Map;



public class ReservationTracker {
    private Map<String, Integer> reservations = new HashMap<>();

    public boolean isWithinLimit(String key, int limit) {
        return reservations.getOrDefault(key, 0) < limit;
    }

    public void incrementCount(String key) {
        reservations.put(key, reservations.getOrDefault(key, 0) + 1);
    }
}
