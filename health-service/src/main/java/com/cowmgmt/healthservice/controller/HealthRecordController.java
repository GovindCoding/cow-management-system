
package com.cowmgmt.healthservice.controller;

import com.cowmgmt.healthservice.model.HealthRecord;
import com.cowmgmt.healthservice.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
public class HealthRecordController {

    @Autowired
    private HealthService service;

    @PostMapping
    public ResponseEntity<HealthRecord> save(@RequestBody HealthRecord healthRecord) {
        return ResponseEntity.ok(service.save(healthRecord));
    }

    @GetMapping
    public List<HealthRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/cow/{cowId}")
    public List<HealthRecord> byCow(@PathVariable Long cowId) {
        return service.getByCowId(cowId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
