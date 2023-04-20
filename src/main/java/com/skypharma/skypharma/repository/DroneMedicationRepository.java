package com.skypharma.skypharma.repository;

import com.skypharma.skypharma.entity.DroneMedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for DroneMedicationEntity.
 */
@Repository
public interface DroneMedicationRepository extends JpaRepository<DroneMedicationEntity, Long> {
    @Query("SELECT dm FROM DroneMedicationEntity dm WHERE dm.drone.id = :droneId")
    List<DroneMedicationEntity> findByDroneId(@Param("droneId") Long droneId);
}
