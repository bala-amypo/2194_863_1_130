package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService {

    WarrantyClaimRecord submit(WarrantyClaimRecord claim);

    List<WarrantyClaimRecord> getAll();

    WarrantyClaimRecord getById(Long id);

    WarrantyClaimRecord updateStatus(Long id, String status);
}
