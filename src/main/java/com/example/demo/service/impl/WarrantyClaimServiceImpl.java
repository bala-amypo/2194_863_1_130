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
    public WarrantyClaimRecord submit(WarrantyClaimRecord claim) {

        DeviceOwnershipRecord device = deviceRepo
                .findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new RuntimeException("Device not found"));

        boolean isStolen = stolenRepo.existsBySerialNumber(claim.getSerialNumber());

        boolean isExpired = device.getWarrantyExpiration() != null
                && device.getWarrantyExpiration().isBefore(LocalDate.now());

        boolean isDuplicate = claimRepo.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(),
                claim.getClaimReason()
        );

        if (isStolen || isExpired || isDuplicate) {
            claim.setStatus("FLAGGED");
        } else {
            claim.setStatus("PENDING");
        }

        return claimRepo.save(claim);
    }

    // Update claim status
    @Override
    public WarrantyClaimRecord updateStatus(Long id, String status) {

        WarrantyClaimRecord claim = claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        claim.setStatus(status);
        return claimRepo.save(claim);
    }

    // Get claim by ID
    @Override
    public WarrantyClaimRecord getById(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }

    // Get all claims
    @Override
    public List<WarrantyClaimRecord> getAll() {
        return claimRepo.findAll();
    }

    // Get claims by serial number
    @Override
    public List<WarrantyClaimRecord> getBySerial(String serial) {
        return claimRepo.findAllBySerialNumber(serial);
    }
}
