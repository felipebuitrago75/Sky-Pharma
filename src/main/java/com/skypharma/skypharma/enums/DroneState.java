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
    AVAILABLE("Available"), // The drone is available for use
    LOADING("Loading"), // The drone is being loaded with medication
    EN_ROUTE("En route"), // The drone is en route to deliver medication
    RETURNING("Returning"); // The drone is returning after delivering medication

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
