package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    privatAe String serialNumber;

    @Column(nullable = false)
    private String reportedBy;

    private String details;

    public StolenDeviceReport() {
    }

    public StolenDeviceReport(String serialNumber, String reportedBy, String details) {
        this.serialNumber = serialNumber;
        this.reportedBy = reportedBy;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
