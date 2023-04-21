package com.skypharma.skypharma.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.skypharma.skypharma.dto.DroneDto;
import com.skypharma.skypharma.dto.MedicationDto;
import com.skypharma.skypharma.entity.BatteryLowEventLogEntity;
import com.skypharma.skypharma.entity.DroneEntity;
import com.skypharma.skypharma.entity.DroneMedicationEntity;
import com.skypharma.skypharma.entity.MedicationEntity;
import com.skypharma.skypharma.enums.DroneState;
import com.skypharma.skypharma.exception.DroneNotFoundException;
import com.skypharma.skypharma.exception.DispatchStateException;
import com.skypharma.skypharma.repository.BatteryLowEventLogRepository;
import com.skypharma.skypharma.repository.DroneMedicationRepository;
import com.skypharma.skypharma.repository.DroneRepository;
import com.skypharma.skypharma.repository.MedicationRepository;
import com.skypharma.skypharma.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DispatchServiceImpl implements DispatchService {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private DroneRepository droneRepository;
	@Autowired
	private DroneMedicationRepository droneMedicationRepository;
	@Autowired
	private MedicationRepository medicationRepository;
	@Autowired
	private BatteryLowEventLogRepository batteryLowEventLogRepository;

	@Override
	public void   registerDrone(DroneDto droneDto) {
		// Set the drone's initial state to IDLE
		DroneEntity drone = DroneEntity.builder()
				.model(droneDto.getModel())
				.serialNumber(droneDto.getSerialNumber())
				.maxWeight(droneDto.getModel().getMaxWeight()) // set max weight limit to 500
				.state(DroneState.IDLE)
				.build();

		// Save the drone to the database
		droneRepository.save(drone);
	}


	/**
	 * Loads the given list of medication items onto the drone with the given ID.
	 * Updates the drone's state to LOADING if it was previously in IDLE state.
	 * Throws an exception if the drone is not in IDLE state or if the total weight of
	 * the medication items exceeds the drone's weight limit.
	 *
	 * @param id the ID of the drone to load
	 * @param medicationIds the list of medication items to load onto the drone
	 * @throws DroneNotFoundException if no drone is found with the given ID
	 * @throws DispatchStateException if the drone is not in IDLE state
	 * @throws IllegalArgumentException if the total weight of the medication items
	 * exceeds the drone's weight limit
	 */
	@Override
	public void loadDrone(Long id, List<Long> medicationIds) {
		// Get the drone from the repository
		DroneEntity drone = droneRepository.findById(id)
				.orElseThrow(() -> new DroneNotFoundException(id));

		// Check if the drone is in IDLE state
		if (drone.getState() != DroneState.IDLE) {
			throw new DispatchStateException("Drone must be in IDLE state to load medication items");
		}
		List<MedicationEntity> medication = findMedicationsByIds(medicationIds);
		// Calculate the total weight of the medication items
		int totalWeight = medication.stream()
				.mapToInt(MedicationEntity::getWeight)
				.sum();

		// Check if the total weight exceeds the drone's weight limit
		if (totalWeight > drone.getMaxWeight()) {
			throw new DispatchStateException("Total weight of medication items exceeds drone's weight limit");
		}

		// Update the drone's state to LOADING
		drone.setState(DroneState.LOADING);
		drone.setLastUsed(LocalDateTime.now());
		// Create DroneMedicationEntity objects from the MedicationEntity objects and add them to the drone's list of loaded medications
		new DroneMedicationEntity();
		List<DroneMedicationEntity> loadedMedications = medication.stream()
				.map(med -> DroneMedicationEntity.builder()
						.drone(drone)
						.medication(med)
						.quantity(1)
						.build())
				.collect(Collectors.toList());

		droneMedicationRepository.saveAll(loadedMedications);
		// Save the updated drone to the repository
		drone.setState(DroneState.LOADED);
		droneRepository.save(drone);
	}

	public List<MedicationEntity> findMedicationsByIds(List<Long> medicationIds) {
		List<MedicationEntity> medications = medicationRepository.findAllById(medicationIds);
		if (medications.size() != medicationIds.size()) {
			throw new DispatchStateException("One or more medications not found");
		}
		return medications;
	}

	/**
	 * Returns the list of medication items loaded onto the drone with the given ID.
	 *
	 * @param id the ID of the drone
	 * @return the list of medication items loaded onto the drone
	 * @throws DroneNotFoundException if the drone with the given ID is not found
	 */
	@Override
	public List<MedicationEntity> getLoadedMedications(Long id) {
		// Get the drone from the repository
		DroneEntity drone = droneRepository.findById(id)
				.orElseThrow(() -> new DroneNotFoundException(id));

		// Get the list of loaded medication entities from the drone
		List<DroneMedicationEntity> loadedMedicationEntities = droneMedicationRepository.findByDroneId(id);

		// Create a list of MedicationEntity objects from the DroneMedicationEntity objects
		List<MedicationEntity> loadedMedications = loadedMedicationEntities.stream()
				.map(DroneMedicationEntity::getMedication)
				.collect(Collectors.toList());

		return loadedMedications;
	}


	/**
	 * Returns a list of all DroneMedicationEntity objects loaded on any drone.
	 *
	 * @return a list of DroneMedicationEntity objects
	 */
	@Override
	public List<DroneEntity> getAllDrones() {
		return droneRepository.findAll();
	}

	@Override
	public Integer getDroneBatteryLevel(Long id) {
		// Get the drone from the repository
		DroneEntity drone = droneRepository.findById(id)
				.orElseThrow(() -> new DroneNotFoundException(id));
		return drone.getBatteryLevel();
	}

	@Override
	public List<DroneEntity> getDronesAvailable() {
		// Retrieve all drones from the repository
		List<DroneEntity> allDrones = droneRepository.findAll();

		// Filter the drones to only include those in IDLE state
		return allDrones.stream()
				.filter(drone -> drone.getState() == DroneState.IDLE)
				.collect(Collectors.toList());
	}

	@Override
	public void registerMedicine(MedicationDto medicationDto) {
		MedicationEntity medication = MedicationEntity.builder()
				.weight(medicationDto.getWeight())
				.image(medicationDto.getImage())
				.build();
		medication.setCode(medicationDto.getCode());
		medication.setName(medicationDto.getName());
		medicationRepository.save(medication);
	}

	@Override
	public List<MedicationDto> getAllMedication() {
		List<MedicationEntity> medications = medicationRepository.findAll();
		return medications.stream()
				.map(medication -> MedicationDto.builder()
						.id(medication.getId()  )
						.name(medication.getName())
						.weight(medication.getWeight())
						.code(medication.getCode())
						.build())
				.collect(Collectors.toList());
	}

	@Override
	public void createBatteryLowEventLog(DroneEntity drone, int batteryLevel, LocalDateTime now) {
		// Create a new BatteryLowEventLogEntity
		BatteryLowEventLogEntity log = BatteryLowEventLogEntity.builder()
				.drone(drone)
				.batteryLevel(batteryLevel)
				.timestamp(now)
				.build();

		// Save the log to the database
		batteryLowEventLogRepository.save(log);
	}

	@Override
	public List<BatteryLowEventLogEntity> getAllLogs() {
		return batteryLowEventLogRepository.findAll();
	}

}
