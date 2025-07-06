package com.cowmgmt.cow.controller;

import com.cowmgmt.cow.model.Cow;
import com.cowmgmt.cow.repository.CowRepository;
import com.cowmgmt.cow.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cows")
public class CowController {

    @Autowired
    private CowService service;

    @PostMapping
    public ResponseEntity<Cow> save(@RequestBody Cow cow) {
        return ResponseEntity.ok(service.save(cow));
    }

    @GetMapping
    public List<Cow> getAllCows() {
        return service.getAll();
    }

    @GetMapping("/cow/{cowId}")
    public List<Cow> byCow(@PathVariable Long cowId) {
        return service.getByCowId(cowId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}