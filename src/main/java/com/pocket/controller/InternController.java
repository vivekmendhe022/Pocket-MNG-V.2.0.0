package com.pocket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocket.dto.InternDTO;
import com.pocket.service.InternService;

@RestController
@RequestMapping("/intern")
@CrossOrigin("*")
public class InternController {

    @Autowired
    private InternService internService;

    @PostMapping
    public ResponseEntity<InternDTO> addIntern(@RequestBody InternDTO dto) {
        InternDTO createdIntern = internService.addIntern(dto);
        return ResponseEntity.ok(createdIntern);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternDTO> getIntern(@PathVariable Long id) {
        InternDTO internDTO = internService.getInternById(id);
        return ResponseEntity.ok(internDTO);
    }

    @GetMapping
    public ResponseEntity<List<InternDTO>> getAllInterns() {
        List<InternDTO> interns = internService.getAllInterns();
        return ResponseEntity.ok(interns);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternDTO> updateIntern(@PathVariable Long id, @RequestBody InternDTO dto) {
        InternDTO updatedIntern = internService.updateIntern(id, dto);
        return ResponseEntity.ok(updatedIntern);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntern(@PathVariable Long id) {
        internService.deleteIntern(id);
        return ResponseEntity.noContent().build();
    }
}
