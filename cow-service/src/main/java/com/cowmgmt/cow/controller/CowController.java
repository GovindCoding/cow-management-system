package com.cowmgmt.cow.controller;

import com.cowmgmt.cow.model.Cow;
import com.cowmgmt.cow.service.CowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Cow> byId(@PathVariable Long id) {
        Optional<Cow> cow = service.getById(id);
        return cow.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}