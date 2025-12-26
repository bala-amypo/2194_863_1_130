package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alerts")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;

    private String reason;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ---------- GETTERS & SETTERS ----------

    public Long getId() {
        return id;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
