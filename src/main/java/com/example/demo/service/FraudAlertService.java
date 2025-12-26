package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;
import java.util.List;

public interface FraudAlertService {
    List<FraudAlertRecord> getAllAlerts();
    FraudAlertRecord addAlert(FraudAlertRecord alert);
}
