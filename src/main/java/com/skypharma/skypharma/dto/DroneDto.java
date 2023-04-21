package com.skypharma.skypharma.dto;

import com.skypharma.skypharma.enums.DroneModel;
import com.skypharma.skypharma.enums.DroneState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all arguments
@NoArgsConstructor // Generates a default constructor
@Builder
public class DroneDto {
    /**
     * Attribute representing the current state of the drone
     */
    @NotNull
    private DroneState state;

    /**
     * Attribute representing the current state of the drone
     */
    @NotNull
    private DroneModel model;

    /**
     * Attribute representing the current battery level of the drone
     */
    @NotNull
    private Integer batteryLevel;

    /**
     * Attribute representing the serial number
     */
    @NotNull
    private int serialNumber;

}
