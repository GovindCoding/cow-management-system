package com.cowmgmt.insurance.repository;

import com.cowmgmt.insurance.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    List<Insurance> findByCowId(Long cowId);
}
