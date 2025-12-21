package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WarrantyClaimRecord> submit(@RequestBody WarrantyClaimRecord claim) {
        return ResponseEntity.ok(service.submit(claim));
    }

    @GetMapping
    public ResponseEntity<List<WarrantyClaimRecord>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarrantyClaimRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<WarrantyClaimRecord> updateStatus(@PathVariable Long id,
                                                            @RequestParam String status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }
}
