package com.cowmgmt.cow.repository;

import com.cowmgmt.cow.model.Cow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CowRepository extends JpaRepository<Cow, Long> {
    List<Cow> findByCowId(Long cowId);
}