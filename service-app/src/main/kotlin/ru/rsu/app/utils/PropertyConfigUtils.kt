package ru.rsu.app.utils

import com.typesafe.config.ConfigFactory
import ru.rsu.app.dto.utils.KafkaProperty

class PropertyConfigUtils {
    private val config = ConfigFactory.load()
    fun getKafkaProperty(): KafkaProperty {
        return KafkaProperty(
            config.getString("ktor.kafka.bootstrap-servers"),
            config.getString("ktor.kafka.key-serializer"),
            config.getString("ktor.kafka.value-serializer"),
            config.getString("ktor.kafka.key-deserializer"),
            config.getString("ktor.kafka.value-deserializer"),
            config.getString("ktor.kafka.group-id"),
            config.getStringList("ktor.kafka.topics")
        )
    }
}