package ru.rsu.app.dto

import kotlinx.serialization.Serializable

@Serializable
data class RoleDto(val name: String, val description: String? = null)