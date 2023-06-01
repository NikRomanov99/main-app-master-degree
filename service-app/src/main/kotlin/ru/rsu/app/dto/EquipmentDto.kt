package ru.rsu.app.dto

import kotlinx.serialization.Serializable


@Serializable
data class EquipmentDto(
    val name: String,
    val equipmentTypeId: Long,
    val serviceLifeInYear: Int? = 0,
    val manufacture: String? = null,
    val manufactureDate: String? = null,
    val serialNumber: String? = null
)