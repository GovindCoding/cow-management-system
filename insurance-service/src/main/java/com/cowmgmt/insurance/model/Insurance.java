package com.cowmgmt.insurance.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cowId;
    private String policyNumber;
    private String provider;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double coverageAmount;

    // Getters and Setters
}
