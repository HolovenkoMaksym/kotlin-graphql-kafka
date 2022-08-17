package com.holovenko.smart_devices_simulator.message.service.impl

import com.holovenko.smart_devices_simulator.device.enum.DeviceType
import com.holovenko.smart_devices_simulator.device.model.Device
import com.holovenko.smart_devices_simulator.message.service.MessageService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.util.UUID

internal class MessageServiceImplTest {

    private val messageService: MessageService = MessageServiceImpl()

    private val devices = listOf(
        Device(UUID.randomUUID(), DeviceType.AIR_CONDITIONER),
        Device(UUID.randomUUID(), DeviceType.ALARM),
        Device(UUID.randomUUID(), DeviceType.CAMERA),
        Device(UUID.randomUUID(), DeviceType.LIGHT_CONTROLLER),
        Device(UUID.randomUUID(), DeviceType.MUSIC_PLAYER),
    )

    @Test
    fun `messagesFromEachDevice generates correct amount of messages`() {
        val messagesAmountFromEachDevice = 5
        val messages = messageService.messagesFromEachDevice(devices, messagesAmountFromEachDevice)
        assertEquals(25, messages.size)
    }

    @Test
    fun `messagesFromEachDevice should contain only message type related to its device`() {
        val messagesAmountFromEachDevice = 5
        val messages = messageService.messagesFromEachDevice(devices, messagesAmountFromEachDevice)

        val airConditioner = devices[0]
        val alarm = devices[1]
        val camera = devices[2]
        val lightController = devices[3]
        val musicPlayer = devices[4]

        val airConditionerMessages = messages.filter { it.device == airConditioner }
        val alarmMessages = messages.filter { it.device == alarm }
        val cameraMessages = messages.filter { it.device == camera }
        val lightControllerMessages = messages.filter { it.device == lightController }
        val musicPlayerMessages = messages.filter { it.device == musicPlayer }

        assertAll({
            assertTrue(airConditionerMessages.all { it.device.type.availableMessageTypes.contains(it.type) })
            assertTrue(alarmMessages.all { it.device.type.availableMessageTypes.contains(it.type) })
            assertTrue(cameraMessages.all { it.device.type.availableMessageTypes.contains(it.type) })
            assertTrue(lightControllerMessages.all { it.device.type.availableMessageTypes.contains(it.type) })
            assertTrue(musicPlayerMessages.all { it.device.type.availableMessageTypes.contains(it.type) })
        })
    }
}