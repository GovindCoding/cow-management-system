package com.cowmgmt.insurance.controller;

import com.cowmgmt.insurance.model.Insurance;
import com.cowmgmt.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService service;

    @PostMapping
    public ResponseEntity<Insurance> save(@RequestBody Insurance insurance) {
        return ResponseEntity.ok(service.save(insurance));
    }

    @GetMapping
    public List<Insurance> all() {
        return service.getAll();
    }

    @GetMapping("/cow/{cowId}")
    public List<Insurance> byCow(@PathVariable Long cowId) {
        return service.getByCowId(cowId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
