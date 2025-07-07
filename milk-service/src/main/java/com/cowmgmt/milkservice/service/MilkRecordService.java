package com.cowmgmt.milkservice.service;

import com.cowmgmt.milkservice.model.MilkRecord;
import com.cowmgmt.milkservice.repository.MilkRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilkRecordService {
    @Autowired
    private MilkRecordRepository repo;

    public MilkRecord save(MilkRecord milkRecord) {
        return repo.save(milkRecord);
    }

    public List<MilkRecord> getAll() {
        return repo.findAll();
    }

    public List<MilkRecord> getByCowId(Long cowId) {
        return repo.findByCowId(cowId);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
