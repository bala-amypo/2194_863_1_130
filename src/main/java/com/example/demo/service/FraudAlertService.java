package com.example.demo.service;

public interface FraudAlertService {
    void sendAlert(String alertMessage);
}

public interface FraudRuleService {
    void applyRule(String ruleName);
}

public interface StolenDeviceService {
    void reportDevice(String deviceId);
}
