package com.example.demo.repository;

import com.example.demo.model.StolenDevice;
import java.util.List;

public interface StolenDeviceRepository {
    List<StolenDevice> findAll();
    StolenDevice save(StolenDevice device);
}
