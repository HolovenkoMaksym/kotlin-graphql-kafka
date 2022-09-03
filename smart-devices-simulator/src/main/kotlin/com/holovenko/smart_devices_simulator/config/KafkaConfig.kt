package com.holovenko.smart_devices_simulator.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "kafka")
data class KafkaConfig (
    val topicName: String,
    val bootstrapServers: String
    )
