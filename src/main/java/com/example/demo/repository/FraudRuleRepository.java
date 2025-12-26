package com.example.demo.repository;

import com.example.demo.model.FraudRule;
import java.util.List;

public interface FraudRuleRepository {
    List<FraudRule> findAll();
    FraudRule save(FraudRule rule);
}
