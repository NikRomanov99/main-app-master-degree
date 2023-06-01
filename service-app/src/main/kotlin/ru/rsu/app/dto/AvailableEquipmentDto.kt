package ru.rsu.app.dto

import kotlinx.serialization.Serializable

@Serializable
data class AvailableEquipmentDto(
    val equipmentId: Long,
    val description: String? = null,
    val lastInspectionDate: String? = null,
    val userId: Long,
    val factoryId: Long
)
