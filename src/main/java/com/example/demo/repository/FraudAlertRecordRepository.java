package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import java.util.List;

public interface FraudAlertRecordRepository {
    List<FraudAlertRecord> findAll();
    FraudAlertRecord save(FraudAlertRecord record);
}
