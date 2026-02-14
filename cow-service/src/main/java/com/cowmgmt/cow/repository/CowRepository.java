package com.cowmgmt.cow.repository;

import com.cowmgmt.cow.model.Cow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CowRepository extends JpaRepository<Cow, Long> {
}