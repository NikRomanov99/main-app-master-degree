package ru.rsu.app.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class FactoryResponseDto(val id: Long, val name: String, val companyName: String? = "", val address: String? = "")