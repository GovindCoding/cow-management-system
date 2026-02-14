package com.cowmgmt.cow.service;

import com.cowmgmt.cow.model.Cow;
import com.cowmgmt.cow.repository.CowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CowService {
    @Autowired
    private CowRepository repo;

    public Cow save(Cow Cow) {
        return repo.save(Cow);
    }

    public List<Cow> getAll() {
        return repo.findAll();
    }

    public Optional<Cow> getById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
