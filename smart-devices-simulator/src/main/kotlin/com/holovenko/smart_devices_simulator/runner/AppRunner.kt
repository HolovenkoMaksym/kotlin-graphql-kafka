package com.holovenko.smart_devices_simulator.runner

import com.holovenko.smart_devices_simulator.config.KafkaConfig
import com.holovenko.smart_devices_simulator.device.service.DeviceService
import com.holovenko.smart_devices_simulator.message.model.Message
import com.holovenko.smart_devices_simulator.message.service.MessageService
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class AppRunner(
    private val messageService: MessageService,
    private val deviceService: DeviceService,
    private val kafkaTemplate: KafkaTemplate<String, Message>,
    private val kafkaConfig: KafkaConfig
) : ApplicationRunner {
    private val logger = LoggerFactory.getLogger(AppRunner::class.java)

    override fun run(args: ApplicationArguments?) {
        deviceService.createRandomDevices(10)
        while (true) {
            val messages = messageService.messagesFromEachDevice(deviceService.allDevices(), 5)
            messages.forEach {
                kafkaTemplate.send(kafkaConfig.topicName, it)
                logger.info("Message published: {}", it)
            }
        }
    }
}