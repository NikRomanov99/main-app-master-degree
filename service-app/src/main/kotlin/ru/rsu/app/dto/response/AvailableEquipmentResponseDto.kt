package ru.rsu.app.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class AvailableEquipmentResponseDto(
    val id: Long,
    val equipmentName: String? = "",
    val description: String? = "",
    var lastInspectionDate: String? = "",
    val userName: String? = "",
    val userSurname: String? = "",
    val factoryName: String? = ""
)
