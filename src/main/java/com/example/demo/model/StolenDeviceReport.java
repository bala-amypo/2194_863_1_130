package com.example.demo.model;

public class StolenDeviceReport {

    private Long id;
    private StolenDevice stolenDevice;
    private String description;

    public StolenDeviceReport() {}

    public StolenDeviceReport(Long id, StolenDevice stolenDevice, String description) {
        this.id = id;
        this.stolenDevice = stolenDevice;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
