
package com.cowmgmt.milkservice.repository;

import com.cowmgmt.milkservice.model.MilkRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MilkRecordRepository extends JpaRepository<MilkRecord, Long> {
    List<MilkRecord> findByCowId(Long cowId);
}
