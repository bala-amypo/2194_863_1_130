package com.example.demo.model;

public class FraudAlertRecord {
    private Long id;
    private String alertMessage;

    public FraudAlertRecord() {}
    public FraudAlertRecord(Long id, String alertMessage) {
        this.id = id;
        this.alertMessage = alertMessage;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAlertMessage() { return alertMessage; }
    public void setAlertMessage(String alertMessage) { this.alertMessage = alertMessage; }
}
