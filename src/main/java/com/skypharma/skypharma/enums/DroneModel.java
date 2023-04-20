package com.skypharma.skypharma.enums;

/**
 * Enum representing the different models of drones.
 */
import lombok.Getter;

/**
 * Enum representing the model of a drone.
 */
@Getter
public enum DroneModel {

    LIGHTWEIGHT("Lightweight", 100), // Max weight limit of 100 grams
    MIDDLEWEIGHT("Middleweight", 250), // Max weight limit of 250 grams
    CRUISERWEIGHT("Cruiserweight", 400), // Max weight limit of 400 grams
    HEAVYWEIGHT("Heavyweight", 500); // Max weight limit of 500 grams

    private final String name;
    private final int maxWeight;

    DroneModel(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
    }
}

