package ru.rsu.app.dto.utils

data class KafkaProperty(
    val bootstrapServer: String,
    val keySerializer: String,
    val valueSerializer: String,
    val keyDeserializer: String,
    val valueDeserializer: String,
    val groupId: String,
    val topics: List<String>
)
