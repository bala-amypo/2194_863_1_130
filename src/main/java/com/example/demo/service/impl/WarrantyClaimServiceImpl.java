package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyClaimService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

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

    @Override
    public WarrantyClaimRecord submit(WarrantyClaimRecord claim) {

        var device = deviceRepo.findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Offer not found"));

        boolean flagged = false;

        if (stolenRepo.existsBySerialNumber(claim.getSerialNumber())) {
            flagged = true;
        }

        if (device.getWarrantyExpiration().isBefore(LocalDate.now())) {
            flagged = true;
        }

        if (claimRepo.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(), claim.getClaimReason())) {
            flagged = true;
        }

        claim.setStatus(flagged ? "FLAGGED" : "PENDING");
        return claimRepo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateStatus(Long id, String status) {
        WarrantyClaimRecord claim = getById(id);
        claim.setStatus(status);
        return claimRepo.save(claim);
    }

    @Override
    public WarrantyClaimRecord getById(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Request not found"));
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return claimRepo.findAll();
    }

    @Override
    public List<WarrantyClaimRecord> getBySerial(String serial) {
        return claimRepo.findBySerialNumber(serial);
    }
}
