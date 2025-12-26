package com.example.demo.service.impl;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    @Autowired
    private WarrantyClaimRecordRepository repository;

    @Override
    public WarrantyClaimRecord create(WarrantyClaimRecord record) {
        return repository.save(record);
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public WarrantyClaimRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
