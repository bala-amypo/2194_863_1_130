package com.example.demo.service.impl;

import com.example.demo.model.StolenDevice;
import com.example.demo.repository.StolenDeviceRepository;
import com.example.demo.service.StolenDeviceService;
import java.util.List;

public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceRepository repository;

    public StolenDeviceServiceImpl(StolenDeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StolenDevice> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public StolenDevice addDevice(StolenDevice device) {
        return repository.save(device);
    }
}
