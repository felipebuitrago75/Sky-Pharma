package com.skypharma.skypharma.scheduler;

import com.skypharma.skypharma.entity.DroneEntity;
import com.skypharma.skypharma.service.DispatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Class to periodically check the battery levels of drones
 */
@Component // Indicates that this is a Spring component
@Slf4j // Generates a logger instance variable for logging messages
public class BatteryLevelChecker {

    @Autowired
    private DispatchService dispatchService; // Injects the DispatchService dependency

    /**
     * Scheduled method to check the battery levels of drones every 10 minutes
     */
    @Scheduled(cron = "0 * * * * *")// Specifies the cron expression for running the method every 1 minute
    public void checkBatteryLevels() {
        log.info("Checking battery levels of drones...");
        for (DroneEntity drone : dispatchService.getAllDrones()) { // Gets all drones and iterates through them
            int batteryLevel = drone.getBatteryLevel(); // Gets the battery level of the drone
            log.info("Drone {} battery level: {}", drone.getSerialNumber(), batteryLevel);
            if (batteryLevel <= 20) { // If the battery level is less than or equal to 20
                log.warn("Drone {} battery level low: {}", drone.getSerialNumber(), batteryLevel);
                dispatchService.createBatteryLowEventLog(drone, batteryLevel, LocalDateTime.now()); // Creates a battery low event log for the drone
            }
        }
    }
}
