package com.holovenko.smart_devices_simulator.device.enum

import com.holovenko.smart_devices_simulator.message.enum.MessageType

enum class DeviceType (val availableMessageTypes: List<MessageType>) {
    CAMERA (
        listOf(
            MessageType.HOME_OWNER_DETECTED,
            MessageType.SUSPICIOUS_ACTIVITY_OUTSIDE,
            MessageType.SUSPICIOUS_ACTIVITY_INSIDE,
            MessageType.COURIER_DETECTED
        )
    ),
    MUSIC_PLAYER (
        listOf(
            MessageType.MUSIC_TO_LOUD,
            MessageType.MUSIC_TO_QUITE,
            MessageType.WORKOUT_MUSIC_ENABLED,
            MessageType.SEX_MUSIC_ENABLED
        )
    ),
    LIGHT_CONTROLLER (
        listOf(
            MessageType.LIGHT_ENABLED_IN_BRIGHT_PERIOD,
            MessageType.LIGHT_EXPECTED_LIMIT_EXCEED,
            MessageType.LIGHT_ENABLED_WHILE_SLEEPING,
        )
    ),
    ALARM (
        listOf(
            MessageType.MORNING_ALARM_SKIPPED,
            MessageType.MORNING_ALARM_DID_NOT_WORKED,
            MessageType.MORNING_ALARM_TURNED_OFF_IN_TIME
        )
    ),
    AIR_CONDITIONER (
        listOf(
            MessageType.TEMPERATURE_BELOW_COMFORTABLE,
            MessageType.TEMPERATURE_ABOVE_COMFORTABLE,
            MessageType.NIGHT_MODE_ENABLED,
            MessageType.TEMPERATURE_MAINTAINING_ENABLED
        )
    )
}