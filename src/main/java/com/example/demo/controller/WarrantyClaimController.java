package com.example.demo.controller;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranty-claims")
public class WarrantyClaimController {

    @Autowired
    private WarrantyClaimService warrantyClaimService;

    @PostMapping
    public WarrantyClaimRecord create(@RequestBody WarrantyClaimRecord record) {
        return warrantyClaimService.create(record);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAll() {
        return warrantyClaimService.getAll();
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getById(@PathVariable Long id) {
        return warrantyClaimService.getById(id);
    }
}
