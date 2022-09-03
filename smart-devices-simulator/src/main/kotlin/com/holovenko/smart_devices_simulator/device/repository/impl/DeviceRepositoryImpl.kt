package com.holovenko.smart_devices_simulator.device.repository.impl

import com.holovenko.smart_devices_simulator.device.enum.DeviceType
import com.holovenko.smart_devices_simulator.device.model.Device
import com.holovenko.smart_devices_simulator.device.repository.DeviceRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class DeviceRepositoryImpl : DeviceRepository {

    private final val devices: MutableList<Device> = mutableListOf()

    override fun create(type: DeviceType) {
        val id = UUID.randomUUID()
        val device = Device(id, type)
        devices.add(device)
    }

    override fun getAll(): List<Device> {
        return devices
    }
}