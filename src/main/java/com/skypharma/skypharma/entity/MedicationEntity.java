package com.skypharma.skypharma.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Class representing a medication entity
 */
@Entity
@Table(name = "MEDICATION")
@Data
@NoArgsConstructor
public class MedicationEntity {

	/**
	 * Attribute representing the ID of the medication
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MEDICATION")
	private Long id;

	/**
	 * Attribute representing the name of the medication
	 */
	@Column(name = "NAME", nullable = false)
	private String name;

	/**
	 * Attribute representing the weight of the medication in grams
	 */
	@Column(name = "WEIGHT", nullable = false)
	private int weight;

	/**
	 * Attribute representing the code of the medication
	 */
	@Column(name = "CODE", nullable = false)
	private String code;

	/**
	 * Attribute representing the image of the medication
	 */
	@Column(name = "IMAGE")
	private byte[] image;
}
