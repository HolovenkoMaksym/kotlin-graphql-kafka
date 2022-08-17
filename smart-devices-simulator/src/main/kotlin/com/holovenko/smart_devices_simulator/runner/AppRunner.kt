package com.holovenko.smart_devices_simulator.runner

import com.holovenko.smart_devices_simulator.device.service.DeviceService
import com.holovenko.smart_devices_simulator.message.service.MessageService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AppRunner(
    private val messageService: MessageService,
    private val deviceService: DeviceService
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        deviceService.createRandomDevices(10)
        while (true) {
            val messages = messageService.messagesFromEachDevice(deviceService.allDevices(), 5)
            messages.forEach { println(it) }
        }
    }
}