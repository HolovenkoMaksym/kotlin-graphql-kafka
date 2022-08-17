package com.holovenko.smart_devices_simulator.device.repository

import com.holovenko.smart_devices_simulator.device.enum.DeviceType
import com.holovenko.smart_devices_simulator.device.model.Device

interface DeviceRepository {
    fun create(type: DeviceType)
    fun getAll(): List<Device>
}