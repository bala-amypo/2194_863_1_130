package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String serialNumber;
    private String claimStatus;

    public WarrantyClaimRecord() {
    }

    public WarrantyClaimRecord(Long id, String productName, String serialNumber, String claimStatus) {
        this.id = id;
        this.productName = productName;
        this.serialNumber = serialNumber;
        this.claimStatus = claimStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
}
