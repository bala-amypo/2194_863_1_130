package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;

import java.util.ArrayList;
import java.util.List;

public class WarrantyClaimServiceImpl {

    private final List<StolenDeviceReport> reports = new ArrayList<>();

    private StolenDeviceReportRepository reportRepository;

    public WarrantyClaimServiceImpl(StolenDeviceReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public StolenDeviceReport submitClaim(StolenDeviceReport report) {
        reports.add(report);
        return report;
    }

    public List<StolenDeviceReport> getAllClaims() {
        return reports;
    }
}
