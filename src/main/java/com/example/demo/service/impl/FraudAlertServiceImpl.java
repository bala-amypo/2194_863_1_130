package com.example.demo.service.impl;

import com.example.demo.service.FraudAlertService;

public class FraudAlertServiceImpl implements FraudAlertService {

    // Constructor
    public FraudAlertServiceImpl() {
        // Initialization if needed
    }

    @Override
    public void sendAlert(String alertMessage) {
        System.out.println("Alert sent: " + alertMessage);
    }
}
