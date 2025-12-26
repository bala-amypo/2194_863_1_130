package com.example.demo.service;

import com.example.demo.model.FraudRule;
import java.util.List;

public interface FraudRuleService {
    List<FraudRule> getAllRules();
    FraudRule addRule(FraudRule rule);
}
