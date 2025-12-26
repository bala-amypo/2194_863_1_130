package com.example.demo.model;

public class StolenDeviceReport {

    private Long id;
    private String deviceImei;
    private String ownerName;
    private String reportStatus;

    public StolenDeviceReport() {}

    public StolenDeviceReport(Long id, String deviceImei, String ownerName, String reportStatus) {
        this.id = id;
        this.deviceImei = deviceImei;
        this.ownerName = ownerName;
        this.reportStatus = reportStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceImei() {
        return deviceImei;
    }

    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }
}
