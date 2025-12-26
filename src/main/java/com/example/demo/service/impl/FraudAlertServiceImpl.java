package com.example.demo.service.impl;

import com.example.demo.service.FraudAlertService;

public class FraudAlertServiceImpl implements FraudAlertService {
    @Override
    public void sendAlert(String alertMessage) {
        System.out.println("Alert sent: " + alertMessage);
    }
}

package com.example.demo.service.impl;

import com.example.demo.service.FraudRuleService;

public class FraudRuleServiceImpl implements FraudRuleService {
    @Override
    public void applyRule(String ruleName) {
        System.out.println("Rule applied: " + ruleName);
    }
}

package com.example.demo.service.impl;

import com.example.demo.service.StolenDeviceService;

public class StolenDeviceServiceImpl implements StolenDeviceService {
    @Override
    public void reportDevice(String deviceId) {
        System.out.println("Device reported: " + deviceId);
    }
}
