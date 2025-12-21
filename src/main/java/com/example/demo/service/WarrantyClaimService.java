package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimService {

    WarrantyClaimRecord submit(WarrantyClaimRecord claim);

    WarrantyClaimRecord updateStatus(Long id, String status);

    WarrantyClaimRecord getById(Long id);

    List<WarrantyClaimRecord> getAll();

    List<WarrantyClaimRecord> getBySerial(String serial);
}
