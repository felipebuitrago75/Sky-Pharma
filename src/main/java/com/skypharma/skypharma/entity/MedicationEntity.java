package com.skypharma.skypharma.entity;

import com.skypharma.skypharma.exception.DispatchStateException;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@AllArgsConstructor // Generates a constructor with all arguments
@Builder
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

	public void setName(String name) {
		if (!name.matches("[A-Za-z0-9_-]+")) {
			throw new DispatchStateException("Invalid name for medication: name (allowed only letters, numbers, ‘-‘, ‘_’)");
		}
		this.name = name;
	}

	public void setCode(String code) {
		if (!code.matches("[A-Z0-9_]+")) {
			throw new DispatchStateException("Invalid code for medication: code (allowed only upper case letters, underscore and numbers)");
		}
		this.code = code;
	}
}
