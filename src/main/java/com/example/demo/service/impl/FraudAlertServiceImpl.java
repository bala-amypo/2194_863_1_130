// src/main/java/com/example/demo/service/impl/FraudAlertServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.service.FraudAlertService;

public class FraudAlertServiceImpl implements FraudAlertService {

    @Override
    public void sendAlert(String alertMessage) {
        System.out.println("Alert sent: " + alertMessage);
    }
}
