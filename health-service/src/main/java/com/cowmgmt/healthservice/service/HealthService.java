package com.cowmgmt.healthservice.service;

import com.cowmgmt.healthservice.model.HealthRecord;
import com.cowmgmt.healthservice.repository.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {
    @Autowired
    private HealthRecordRepository repo;

    public HealthRecord save(HealthRecord healthRecord) {
        return repo.save(healthRecord);
    }

    public List<HealthRecord> getAll() {
        return repo.findAll();
    }

    public List<HealthRecord> getByCowId(Long cowId) {
        return repo.findByCowId(cowId);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
