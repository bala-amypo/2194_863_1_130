package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import java.util.List;

public class StolenDeviceServiceImpl {

    private final StolenDeviceReportRepository repository;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository repository) {
        this.repository = repository;
    }

    public StolenDeviceReport save(StolenDeviceReport report) {
        return repository.save(report);
    }

    public List<StolenDeviceReport> getAll() {
        return repository.findAll();
    }
}
