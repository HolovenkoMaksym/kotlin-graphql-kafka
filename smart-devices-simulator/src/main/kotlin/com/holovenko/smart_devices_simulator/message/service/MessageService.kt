package com.holovenko.smart_devices_simulator.message.service

import com.holovenko.smart_devices_simulator.device.model.Device
import com.holovenko.smart_devices_simulator.message.model.Message

interface MessageService {
    fun messagesFromEachDevice(devices: List<Device>, messagesPerDevice: Int): List<Message>
}