package com.skypharma.skypharma.service;

import java.time.LocalDateTime;
import java.util.List;

import com.skypharma.skypharma.dto.DroneDto;
import com.skypharma.skypharma.dto.MedicationDto;
import com.skypharma.skypharma.entity.BatteryLowEventLogEntity;
import com.skypharma.skypharma.entity.DroneEntity;
import com.skypharma.skypharma.entity.MedicationEntity;

public interface DispatchService {

	/**
	 * Registers a drone
	 *
	 * @param droneDto DTO object containing the details of the drone
	 * @return The registered drone DTO object
	 */
	public void registerDrone(DroneDto droneDto);

	/**
	 * Loads a drone with medications
	 *
	 * @param id            The ID of the drone to load
	 * @param medication List of medication DTO objects to load onto the drone
	 */
	public void loadDrone(Long id, List<Long> medication);

	/**
	 * Retrieves a list of medication DTO objects loaded onto a drone
	 *
	 * @param id The ID of the drone to retrieve the medication list from
	 * @return A list of medication DTO objects loaded onto the drone
	 */
	public List<MedicationEntity> getLoadedMedications(Long id);

	/**
	 * Retrieves a list of all drones
	 *
	 * @return A list of all drones
	 */
	public List<DroneEntity> getAllDrones();

	/**
	 * Retrieves the battery level of a drone
	 *
	 * @param id The ID of the drone to retrieve the battery level from
	 * @return The battery level of the drone
	 */
	public Integer getDroneBatteryLevel(Long id);

	/**
	 * Retrieves a list of all drones
	 *
	 * @return A list of all drones
	 */
	public List<DroneEntity> getDronesAvailable();

	/**
	 * Registers a medicine
	 *
	 * @param medicine DTO object containing the details of the drone
	 * @return The registered drone DTO object
	 */
	public void registerMedicine(MedicationDto medicine);

	/**
	 * Retrieves a list of all drones
	 *
	 * @return A list of all drones
	 */
	public List<MedicationDto> getAllMedication();

	void createBatteryLowEventLog(DroneEntity drone, int batteryLevel, LocalDateTime now);

	List<BatteryLowEventLogEntity> getAllLogs();
}
