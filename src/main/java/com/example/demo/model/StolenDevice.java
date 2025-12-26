package com.example.demo.model;

public class StolenDevice {

    private Long id;
    private String imei;
    private String ownerName;

    public StolenDevice() {}

    public StolenDevice(Long id, String imei, String ownerName) {
        this.id = id;
        this.imei = imei;
        this.ownerName = ownerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
