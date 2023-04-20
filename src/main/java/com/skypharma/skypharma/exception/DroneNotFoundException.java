package com.skypharma.skypharma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * Custom exception for drones not found
 */
@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DroneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Long droneId;

	public DroneNotFoundException(Long droneId) {
		super(String.format("Drone with ID %d not found", droneId));
		this.droneId = droneId;
	}
}
