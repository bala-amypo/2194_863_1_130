package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service   // 🔴 THIS FIXES YOUR ERROR
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final List<WarrantyClaimRecord> claims = new ArrayList<>();

    @Override
    public WarrantyClaimRecord submit(WarrantyClaimRecord claim) {
        claims.add(claim);
        return claim;
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return claims;
    }

    @Override
    public WarrantyClaimRecord getById(Long id) {
        return claims.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }

    @Override
    public WarrantyClaimRecord updateStatus(Long id, String status) {
        WarrantyClaimRecord claim = getById(id);
        claim.setStatus(status);
        return claim;
    }
}
