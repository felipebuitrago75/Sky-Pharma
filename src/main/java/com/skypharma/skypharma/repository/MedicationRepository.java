package com.skypharma.skypharma.repository;

import com.skypharma.skypharma.entity.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for MedicationRepository.
 */
@Repository
public interface MedicationRepository  extends JpaRepository<MedicationEntity, Long> {

}
