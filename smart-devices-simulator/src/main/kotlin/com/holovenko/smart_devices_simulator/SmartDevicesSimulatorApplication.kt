package com.holovenko.smart_devices_simulator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class SmartDevicesSimulatorApplication

fun main(args: Array<String>) {
    runApplication<SmartDevicesSimulatorApplication>(*args)
}
