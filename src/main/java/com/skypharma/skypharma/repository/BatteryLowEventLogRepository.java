package com.skypharma.skypharma.repository;

import com.skypharma.skypharma.entity.BatteryLowEventLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryLowEventLogRepository extends JpaRepository<BatteryLowEventLogEntity, Long> {

}
