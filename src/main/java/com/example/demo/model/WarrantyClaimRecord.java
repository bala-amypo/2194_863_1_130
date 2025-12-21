package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimReason;
    private String status;

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
