package com.skypharma.skypharma.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Class representing a medication DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationDto {

    /**
     * Attribute representing the name of the medication
     */
    private Long id;

    /**
     * Attribute representing the name of the medication
     */
    private String name;

    /**
     * Attribute representing the weight of the medication in grams
     */
    private int weight;

    /**
     * Attribute representing the code of the medication
     */
    private String code;

    /**
     * Attribute representing the image of the medication
     */
    private byte[] image;
}
