package ru.rsu.app.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class RoleResponseDto(val id: Long, val name: String, val description: String? = "")
