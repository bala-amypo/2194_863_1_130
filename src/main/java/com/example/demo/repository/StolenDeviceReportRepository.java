package com.example.demo.repository;

import com.example.demo.model.StolenDeviceReport;
import java.util.List;

public interface StolenDeviceReportRepository {
    StolenDeviceReport save(StolenDeviceReport report);
    List<StolenDeviceReport> findAll();
    StolenDeviceReport findById(Long id);
}
