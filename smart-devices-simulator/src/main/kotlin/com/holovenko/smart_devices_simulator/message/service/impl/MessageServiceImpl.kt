package com.holovenko.smart_devices_simulator.message.service.impl

import com.holovenko.smart_devices_simulator.device.model.Device
import com.holovenko.smart_devices_simulator.message.model.Message
import com.holovenko.smart_devices_simulator.message.service.MessageService
import com.holovenko.smart_devices_simulator.util.getRandomNumberInRange
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID

@Service
class MessageServiceImpl : MessageService {

    override fun messagesFromEachDevice(devices: List<Device>, messagesPerDevice: Int): List<Message> {
        return devices
            .flatMap { randomMessagesFromDevice(it, messagesPerDevice) }
    }

    private fun randomMessagesFromDevice(device: Device, messagesPerDevice: Int): List<Message> {
        val messages = mutableListOf<Message>()
        for (i in 1..messagesPerDevice) {
            messages.add(randomMessageFromDevice(device))
        }
        return messages
    }

    private fun randomMessageFromDevice(device: Device): Message {
        val availableMessageTypes = device.type.availableMessageTypes
        val randomIndex = getRandomNumberInRange(0..availableMessageTypes.lastIndex)
        val messageType = availableMessageTypes.elementAt(randomIndex)
        return Message(
            id = UUID.randomUUID(),
            device = device,
            type = messageType,
            timestamp = Instant.now()
        )
    }
}