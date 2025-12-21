package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimantName;
    private String claimantEmail;
    private String claimReason;
    private String status = "PENDING";

    private LocalDateTime submittedAt = LocalDateTime.now();

    public WarrantyClaimRecord() {}

    // 🔹 GETTERS & SETTERS
    public Long getId() { return id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getClaimReason() { return claimReason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
