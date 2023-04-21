package com.skypharma.skypharma.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity class representing a battery low event log for a drone.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all arguments
@NoArgsConstructor // Generates a default constructor
@Builder // Implements the Builder design pattern
@Entity // Specifies that this is a JPA entity
@Table(name = "BATTERY_LOW_EVENT_LOG") // Specifies the name of the database table
public class BatteryLowEventLogEntity {

    /**
     * Attribute representing the ID of the battery low event log
     */
    @Id // Specifies that this is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the ID is automatically generated
    @Column(name = "ID")
    private Long id;

    /**
     * Attribute representing the ID of the drone associated with the battery low event
     */
    @ManyToOne(fetch = FetchType.EAGER) // Specifies that this is a ManyToOne relationship
    @JoinColumn(name = "DRONE_ID") // Specifies the name of the foreign key column in the database table
    private DroneEntity drone;

    /**
     * Attribute representing the battery level of the drone when the event occurred
     */
    @Column(name = "BATTERY_LEVEL", nullable = false)
    private int batteryLevel;

    /**
     * Attribute representing the timestamp when the event occurred
     */
    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timestamp;
}
