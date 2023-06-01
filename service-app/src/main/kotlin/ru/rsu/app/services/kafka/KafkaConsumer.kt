package ru.rsu.app.services.kafka

import kotlinx.serialization.json.Json.Default.decodeFromString
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import ru.rsu.app.dto.msg.LastInspectionMsg
import ru.rsu.app.services.AvailableEquipmentService
import ru.rsu.app.utils.PropertyConfigUtils
import java.time.Duration
import java.util.*

class KafkaConsumer(
    private val propertyConfigUtils: PropertyConfigUtils,
    private val availableEquipmentService: AvailableEquipmentService
) {
    suspend fun initConsumers() {
        val kafkaProperty = propertyConfigUtils.getKafkaProperty()
        val config = Properties().apply {
            put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.bootstrapServer)
            put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
            put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
            put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperty.groupId)
        }

        val updateLastInspectionDateConsumer = KafkaConsumer<String, String>(config)
        updateLastInspectionDateConsumer.subscribe(listOf(kafkaProperty.topics.first()))

        while (true) {
            val records: ConsumerRecords<String, String> =
                updateLastInspectionDateConsumer.poll(Duration.ofMillis(1000))
            for (record in records) {
                val value = record.value()

                val updateLastInspectionDateMsg = decodeFromString(LastInspectionMsg.serializer(), value)
                availableEquipmentService.updateLastInspectionDate(updateLastInspectionDateMsg)
            }
        }

        closeConsumers(listOf(updateLastInspectionDateConsumer))
    }

    private fun closeConsumers(consumers: List<KafkaConsumer<String, String>>) {
        consumers.forEach { consumer -> consumer.close() }
    }
}