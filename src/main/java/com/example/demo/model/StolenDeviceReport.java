package com.example.demo.model;

public class StolenDeviceReport {
    private Long id;
    private StolenDevice stolenDevice;
    private String reportDetails;

    public StolenDeviceReport() {}

    public StolenDeviceReport(Long id, StolenDevice stolenDevice, String reportDetails) {
        this.id = id;
        this.stolenDevice = stolenDevice;
        this.reportDetails = reportDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StolenDevice getStolenDevice() {
        return stolenDevice;
    }

    public void setStolenDevice(StolenDevice stolenDevice) {
        this.stolenDevice = stolenDevice;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    @Override
    public String toString() {
        return "StolenDeviceReport{" +
                "id=" + id +
                ", stolenDevice=" + stolenDevice +
                ", reportDetails='" + reportDetails + '\'' +
                '}';
    }
}
