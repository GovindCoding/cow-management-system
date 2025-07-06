
package com.cowmgmt.healthservice.repository;

import com.cowmgmt.healthservice.model.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
    List<HealthRecord> findByCowId(Long cowId);
}
