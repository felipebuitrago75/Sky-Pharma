package com.skypharma.skypharma.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration class representing the state of a drone.
 * <p>
 * This class is annotated with Lombok annotations to generate getters and a constructor with all arguments automatically.
 */
@Getter // Lombok annotation to generate getters for all fields
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public enum DroneState {
    IDLE("IDLE"),// Drone is available for loading or delivering
    LOADING("LOADING"),// Drone is currently being loaded with medication items
        LOADED("LOADED"),// Drone has finished loading and is ready for delivery
    DELIVERING("DELIVERING"),// Drone is currently delivering medication items
    DELIVERED("DELIVERED"),// Drone has completed the delivery of medication items
    RETURNING("RETURNING");// Drone is returning to its base after completing a delivery

    private final String description; // A description of the drone state

    /**
     * Returns the DroneState enumeration value that matches the given string.
     *
     * @param str the string to match
     * @return the corresponding DroneState value, or null if no match is found
     */
    public static DroneState fromString(String str) {
        for (DroneState state : DroneState.values()) {
            if (state.getDescription().equalsIgnoreCase(str)) {
                return state;
            }
        }
        return null;
    }
}
