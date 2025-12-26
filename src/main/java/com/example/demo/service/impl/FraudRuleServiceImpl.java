package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import java.util.ArrayList;
import java.util.List;

public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        return repository.save(rule);
    }
}
