package ru.rsu.app.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class EquipmentResponseDto(
    val id: Long,
    val name: String,
    val equipmentType: String,
    val serviceLifeInYear: Int,
    val manufacture: String? = "",
    val manufactureDate: String? = "",
    val serialNumber: String? = ""
)