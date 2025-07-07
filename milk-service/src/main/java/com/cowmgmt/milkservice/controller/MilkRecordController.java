
package com.cowmgmt.milkservice.controller;

import com.cowmgmt.milkservice.model.MilkRecord;
import com.cowmgmt.milkservice.service.MilkRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milk")
public class MilkRecordController {

    @Autowired
    private MilkRecordService service;

    @PostMapping
    public ResponseEntity<MilkRecord> save(@RequestBody MilkRecord milkRecord) {
        return ResponseEntity.ok(service.save(milkRecord));
    }

    @GetMapping
    public List<MilkRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/cow/{cowId}")
    public List<MilkRecord> byCow(@PathVariable Long cowId) {
        return service.getByCowId(cowId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
