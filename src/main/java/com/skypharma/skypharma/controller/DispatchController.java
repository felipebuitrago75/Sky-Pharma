package com.skypharma.skypharma.controller;

import java.util.List;

import com.skypharma.skypharma.dto.DroneDto;
import com.skypharma.skypharma.dto.DroneMedicationInput;
import com.skypharma.skypharma.dto.MedicationDto;
import com.skypharma.skypharma.entity.BatteryLowEventLogEntity;
import com.skypharma.skypharma.entity.DroneEntity;
import com.skypharma.skypharma.entity.MedicationEntity;
import com.skypharma.skypharma.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class responsible for handling requests related to drone dispatch operations.
 */
@RestController
public class DispatchController {

	@Autowired
	private DispatchService dispatchService;

	/**
	 * Registers a new drone in the system.
	 *
	 * @param drone A {@link DroneDto} representing the drone to be registered.
	 */
	@PostMapping("/addDrone")
	public void addDrone(@RequestBody DroneDto drone) {
		dispatchService.registerDrone(drone);
	}

	/**
	 * Retrieves the current battery level of a drone with the specified ID.
	 *
	 * @param id The ID of the drone to check the battery level for.
	 * @return An {@link Integer} representing the current battery level of the drone.
	 */
	@GetMapping("/checkDroneBattery")
	@ResponseBody
	public Integer checkDroneBattery(Long id) {
		return dispatchService.getDroneBatteryLevel(id);
	}

	/**
	 * Retrieves a list of all drones registered in the system.
	 *
	 * @return A {@link List} of {@link DroneEntity} objects representing all drones registered in the system.
	 */
	@GetMapping("/allDrones")
	@ResponseBody
	public List<DroneEntity> allDrones() {
		return dispatchService.getAllDrones();
	}

	/**
	 * Retrieves a list of medications currently loaded on the drone with the specified ID.
	 *
	 * @param id The ID of the drone to retrieve the loaded medications for.
	 * @return A {@link List} of {@link MedicationEntity} objects representing the medications loaded on the drone.
	 */
	@GetMapping("/getLoadedMedicationForDrone/{id}")
	@ResponseBody
	public List<MedicationEntity> getLoadedMedicationForDrone(Long id) {
		return dispatchService.getLoadedMedications(id);
	}

	/**
	 * Retrieves a list of all drones currently available for dispatch.
	 *
	 * @return A {@link List} of {@link DroneEntity} objects representing all drones currently available for dispatch.
	 */
	@GetMapping("/getDronesAvailable")
	@ResponseBody
	public List<DroneEntity> getDronesAvailable() {
		return dispatchService.getDronesAvailable();
	}

	/**
	 * Loads a list of medications onto the drone with the specified ID.
	 *
	 * @param droneMedicationInput A {@link DroneMedicationInput} object containing the IDs of the drone and medications to load.
	 */
	@PostMapping("/loadDrone")
	public void loadDrone(@RequestBody DroneMedicationInput droneMedicationInput) {
		dispatchService.loadDrone(droneMedicationInput.getDroneId(),droneMedicationInput.getMedicationIds());
	}

	/**
	 * Registers a medicine
	 *
	 * @param medication DTO object containing the details of the drone
	 * @return The registered drone DTO object
	 */
	@PostMapping("/registerMedicine")
	public void registerMedicine(@RequestBody MedicationDto medication){
		dispatchService.registerMedicine(medication);
	}

	/**
	 * Retrieves a list of all Medication
	 *
	 * @return A list of all Medication
	 */
	@GetMapping("/getAllMedication")
	@ResponseBody
	public List<MedicationDto> getAllMedication(){
		return dispatchService.getAllMedication();
	}

	/**
	 * Retrieves a list of all Medication
	 *
	 * @return A list of all Medication
	 */
	@GetMapping("/getAllLogs")
	@ResponseBody
	public List<BatteryLowEventLogEntity> getAllLogs(){
		return dispatchService.getAllLogs();
	}

	public void setDispatchService(DispatchService dispatchService) {
	}
}
