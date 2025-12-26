package com.example.demo.service;

import com.example.demo.model.StolenDevice;
import java.util.List;

public interface StolenDeviceService {
    List<StolenDevice> getAllDevices();
    StolenDevice addDevice(StolenDevice device);
}
