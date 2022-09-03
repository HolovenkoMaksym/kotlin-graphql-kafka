package com.holovenko.smart_devices_simulator.device.service.impl

import com.holovenko.smart_devices_simulator.device.enum.DeviceType
import com.holovenko.smart_devices_simulator.device.model.Device
import com.holovenko.smart_devices_simulator.device.repository.DeviceRepository
import com.holovenko.smart_devices_simulator.device.service.DeviceService
import com.holovenko.smart_devices_simulator.util.getRandomNumberInRange
import org.springframework.stereotype.Service

@Service
class DeviceServiceImpl (private val deviceRepository: DeviceRepository) : DeviceService {

    override fun createRandomDevices(devicesAmount: Int) {
        for (i in 1..devicesAmount) {
            deviceRepository.create(randomDeviceType())
        }
    }

    override fun allDevices(): List<Device> {
        return deviceRepository.getAll()
    }


    private fun randomDeviceType(): DeviceType {
        val allDeviceTypes = DeviceType.values()
        val randomTypeIndex = getRandomNumberInRange(0..allDeviceTypes.lastIndex)
        return allDeviceTypes.elementAt(randomTypeIndex)
    }
}