package com.skypharma.skypharma.entity;

import javax.persistence.*;

import lombok.*;

/**
 * Class representing the relationship between a drone and a medication.
 * A drone can carry multiple medications and each medication can be carried by multiple drones.
 */
@Entity
@Table(name = "DRONE_MEDICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DroneMedicationEntity {

	/**
	 * ID of the relationship between a drone and a medication
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/**
	 * Drone carrying the medication
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DRONE_ID")
	private DroneEntity drone;

	/**
	 * Medication being carried
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEDICATION_ID")
	private MedicationEntity medication;

	/**
	 * Quantity of the medication being carried
	 */
	@Column(name = "QUANTITY")
	private int quantity;

}
