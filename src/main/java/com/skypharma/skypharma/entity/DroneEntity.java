package com.skypharma.skypharma.entity;

import com.skypharma.skypharma.enums.DroneModel;
import com.skypharma.skypharma.enums.DroneState;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class representing the Drone entity
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all arguments
@Builder
@NoArgsConstructor // Generates a default constructor
@Entity // Specifies that this is a JPA entity
@Table(name = "DRONE") // Specifies the name of the database table
public class DroneEntity {

	/**
	 * Attribute representing the ID of the drone
	 */
	@Id // Specifies that this is the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the ID is automatically generated
	@Column(name = "ID")
	private Long id;

	/**
	 * Attribute representing the current state of the drone
	 */
	@Column(name = "STATE")
	@Enumerated(EnumType.STRING) // Specifies that this attribute is an enumerated type
	private DroneState state;

	/**
	 * Attribute representing the current state of the drone
	 */
	@Column(name = "MODEL")
	@Enumerated(EnumType.STRING) // Specifies that this attribute is an enumerated type
	private DroneModel model;

	/**
	 * Attribute representing the time when the drone was last used
	 */
	@Column(name = "LAST_USED")
	private LocalDateTime lastUsed;

	/**
	 * Attribute representing the current battery level of the drone
	 */
	@Column(name = "BATTERY_LEVEL")
	private Integer batteryLevel;

	/**
	 * Attribute representing the weight of the medication in grams
	 */
	@Column(name = "MAXWEIGHT", nullable = false)
	private int maxWeight;

	/**
	 * Attribute representing the serial number of the drone
	 */
	@Column(name = "SERIAL", nullable = false, length = 100)
	private int serialNumber;

}
