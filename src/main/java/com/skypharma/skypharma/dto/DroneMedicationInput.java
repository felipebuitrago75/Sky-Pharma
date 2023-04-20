package com.skypharma.skypharma.dto;

import com.skypharma.skypharma.entity.MedicationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Input DTO for creating or updating a drone medication relationship.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class    DroneMedicationInput {

    /**
     * ID of the drone carrying the medication.
     */
    @NotNull
    private Long droneId;

    /**
     * List of medication IDs being carried by the drone.
     */
    @NotEmpty
    private List<Long> medicationIds;



}
