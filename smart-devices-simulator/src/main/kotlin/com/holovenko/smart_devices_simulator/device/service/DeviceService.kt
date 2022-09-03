package com.holovenko.smart_devices_simulator.device.service

import com.holovenko.smart_devices_simulator.device.model.Device

interface DeviceService {
    fun createRandomDevices(devicesAmount: Int)
    fun allDevices(): List<Device>
}