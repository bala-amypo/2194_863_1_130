package com.example.demo.repository;

import com.example.demo.model.StolenDevice;
import java.util.List;

public interface StolenDeviceRepository {

    StolenDevice save(StolenDevice device);

    List<StolenDevice> findAll();

    StolenDevice findById(Long id);
}
