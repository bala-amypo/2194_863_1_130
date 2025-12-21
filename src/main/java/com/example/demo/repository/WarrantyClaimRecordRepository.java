package com.example.demo.repository;

import com.example.demo.model.WarrantyClaimRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WarrantyClaimRecordRepository
        extends JpaRepository<WarrantyClaimRecord, Long> {

    // Check duplicate claim for same device & reason
    boolean existsBySerialNumberAndClaimReason(String serialNumber, String claimReason);

    // Fetch claim by serial number
    Optional<WarrantyClaimRecord> findBySerialNumber(String serialNumber);
}
