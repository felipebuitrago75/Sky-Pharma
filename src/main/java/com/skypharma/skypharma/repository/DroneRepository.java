package com.skypharma.skypharma.repository;

import com.skypharma.skypharma.entity.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for DroneRepository.
 */
@Repository
public interface DroneRepository  extends JpaRepository<DroneEntity, Long> {


}
