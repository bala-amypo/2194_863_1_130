package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepo,
                                    DeviceOwnershipRecordRepository deviceRepo,
                                    StolenDeviceReportRepository stolenRepo) {
        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
        this.stolenRepo = stolenRepo;
    }

    // Submit a new claim
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        // 1. Check if device exists
        Optional<DeviceOwnershipRecord> deviceOpt = deviceRepo.findBySerialNumber(claim.getSerialNumber());
        if (!deviceOpt.isPresent()) {
            throw new RuntimeException("Device not found");
        }

        DeviceOwnershipRecord device = deviceOpt.get();

        // 2. Check if device is stolen
        boolean isStolen = stolenRepo.existsBySerialNumber(claim.getSerialNumber());

        // 3. Check if warranty expired
        boolean isExpired = device.getWarrantyExpiration() != null &&
                device.getWarrantyExpiration().isBefore(LocalDate.now());

        // 4. Check for duplicate claim
        boolean isDuplicate = claimRepo.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(), claim.getClaimReason()
        );

        // 5. Determine claim status
        if (isStolen || isExpired || isDuplicate) {
            claim.setStatus("FLAGGED");
        } else {
            claim.setStatus("PENDING");
        }

        // 6. Save claim
        return claimRepo.save(claim);
    }

    // Update claim status (ADMIN only)
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {
        Optional<WarrantyClaimRecord> claimOpt = claimRepo.findById(claimId);
        if (!claimOpt.isPresent()) {
            throw new RuntimeException("Claim not found");
        }
        WarrantyClaimRecord claim = claimOpt.get();
        claim.setStatus(status);
        return claimRepo.save(claim);
    }

    // Get claim by ID
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepo.findById(id);
    }

    // Get claims by device serial number
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepo.findAllBySerialNumber(serialNumber); // Make sure this exists in repo
    }

    // Get all claims
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }
}
