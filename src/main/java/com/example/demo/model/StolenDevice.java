package com.example.demo.model;

public class StolenDevice {
    private Long id;
    private String deviceId;
    private String ownerName;

    public StolenDevice() {}

    public StolenDevice(Long id, String deviceId, String ownerName) {
        this.id = id;
        this.deviceId = deviceId;
        this.ownerName = ownerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "StolenDevice{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
