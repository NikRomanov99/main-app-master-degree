package ru.rsu.app.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class EquipmentTypeResponseDto(val id: Long, val name: String, val description: String? = "")
