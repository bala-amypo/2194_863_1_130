package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.WarrantyClaimService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;

    public WarrantyClaimServiceImpl(
            WarrantyClaimRecordRepository claimRepo,
            DeviceOwnershipRecordRepository deviceRepo,
            StolenDeviceReportRepository stolenRepo) {

        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
        this.stolenRepo = stolenRepo;
    }

    // Submit a new warranty claim
    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        // 1. Check if device exists
        DeviceOwnershipRecord device = deviceRepo
                .findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new RuntimeException("Device not found"));

        // 2. Check if device is reported stolen
        boolean isStolen = stolenRepo.existsBySerialNumber(claim.getSerialNumber());

        // 3. Check if warranty expired
        boolean isExpired = device.getWarrantyExpiration() != null
                && device.getWarrantyExpiration().isBefore(LocalDate.now());

        // 4. Check duplicate claim
        boolean isDuplicate = claimRepo.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(),
                claim.getClaimReason()
        );

        // 5. Decide claim status
        if (isStolen || isExpired || isDuplicate) {
            claim.setStatus("FLAGGED");
        } else {
            claim.setStatus("PENDING");
        }

        // 6. Save claim
        return claimRepo.save(claim);
    }

    // Update claim status (ADMIN)
    @Override
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {

        WarrantyClaimRecord claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        claim.setStatus(status);
        return claimRepo.save(claim);
    }

    // Get claim by ID
    @Override
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepo.findById(id);
    }

    // REQUIRED BY INTERFACE (IMPORTANT)
    @Override
    public WarrantyClaimRecord getBySerial(String serial) {
        return claimRepo.findFirstBySerialNumber(serial)
                .orElseThrow(() ->
                        new RuntimeException("Claim not found for serial: " + serial)
                );
    }

    // Get all claims for a serial number
    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepo.findAllBySerialNumber(serialNumber);
    }

    // Get all claims
    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }
}