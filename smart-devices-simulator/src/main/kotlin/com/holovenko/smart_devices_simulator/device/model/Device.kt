package com.holovenko.smart_devices_simulator.device.model

import com.holovenko.smart_devices_simulator.device.enum.DeviceType
import java.util.UUID

data class Device (
    val id: UUID,
    val type: DeviceType
)
