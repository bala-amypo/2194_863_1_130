package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;

import java.util.List;

public class WarrantyClaimServiceImpl {

    private final StolenDeviceReportRepository repository;

    public WarrantyClaimServiceImpl(StolenDeviceReportRepository repository) {
        this.repository = repository;
    }

    public StolenDeviceReport submit(StolenDeviceReport report) {
        return repository.save(report);
    }

    public List<StolenDeviceReport> getAll() {
        return repository.findAll();
    }
}
 