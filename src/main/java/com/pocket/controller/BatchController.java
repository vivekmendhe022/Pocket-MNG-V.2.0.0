package com.pocket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocket.dto.BatchDTO;
import com.pocket.service.BatchService;

@RestController
@RequestMapping("/batch")
@CrossOrigin("*")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @PostMapping
    public ResponseEntity<BatchDTO> addBatch(@RequestBody BatchDTO dto) {
        BatchDTO createdBatch = batchService.addBatch(dto);
        return ResponseEntity.ok(createdBatch);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchDTO> getBatch(@PathVariable Long id) {
        BatchDTO batchDTO = batchService.getBatchById(id);
        return ResponseEntity.ok(batchDTO);
    }

    @GetMapping
    public ResponseEntity<List<BatchDTO>> getAllBatches() {
        List<BatchDTO> batches = batchService.getAllBatches();
        return ResponseEntity.ok(batches);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BatchDTO> updateBatch(@PathVariable Long id, @RequestBody BatchDTO dto) {
        BatchDTO updatedBatch = batchService.updateBatch(id, dto);
        return ResponseEntity.ok(updatedBatch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
        return ResponseEntity.noContent().build();
    }
}
