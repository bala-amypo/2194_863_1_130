package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.FraudAlertRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;
    private final StolenDeviceReportRepository stolenDeviceRepository;
    private final FraudAlertRecordRepository fraudAlertRepository;
    private final FraudRuleRepository fraudRuleRepository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepository,
                                  DeviceOwnershipRecordRepository deviceRepository,
                                  StolenDeviceReportRepository stolenDeviceRepository,
                                  FraudAlertRecordRepository fraudAlertRepository,
                                  FraudRuleRepository fraudRuleRepository) {
        this.claimRepository = claimRepository;
        this.deviceRepository = deviceRepository;
        this.stolenDeviceRepository = stolenDeviceRepository;
        this.fraudAlertRepository = fraudAlertRepository;
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        DeviceOwnershipRecord device = deviceRepository.findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Offer not found"));

        claim.setDevice(device);

        WarrantyClaimRecord savedClaim = claimRepository.save(claim);

        // Check if device is stolen
        if (stolenDeviceRepository.existsBySerialNumber(claim.getSerialNumber())) {
            claim.setStatus("FLAGGED");
            createFraudAlert(savedClaim, "STOLEN_DEVICE", "HIGH", "Device reported as stolen");
        }
        // Check if warranty expired
        else if (device.getWarrantyExpiration().isBefore(LocalDate.now())) {
            claim.setStatus("FLAGGED");
            createFraudAlert(savedClaim, "EXPIRED_WARRANTY", "MEDIUM", "Warranty has expired");
        }
        // Check for duplicate claim
        else if (claimRepository.existsBySerialNumberAndClaimReason(claim.getSerialNumber(), claim.getClaimReason())) {
            claim.setStatus("FLAGGED");
            createFraudAlert(savedClaim, "DUPLICATE_CLAIM", "MEDIUM", "Duplicate claim detected");
        }

        return claimRepository.save(claim);
    }

    private void createFraudAlert(WarrantyClaimRecord claim, String alertType, String severity, String message) {
        FraudAlertRecord alert = new FraudAlertRecord(claim.getId(), claim.getSerialNumber(), alertType, severity, message);
        fraudAlertRepository.save(alert);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {
        WarrantyClaimRecord claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new NoSuchElementException("Request not found"));
        claim.setStatus(status);
        return claimRepository.save(claim);
    }

    @Override
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepository.findAll();
    }
}