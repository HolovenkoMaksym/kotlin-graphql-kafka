package com.holovenko.smart_devices_simulator.message.model

import com.holovenko.smart_devices_simulator.device.model.Device
import com.holovenko.smart_devices_simulator.message.enum.MessageType
import java.time.Instant
import java.util.UUID

data class Message (
    val id: UUID,
    val device: Device,
    val type: MessageType,
    val timestamp: Instant
)
