package ru.rsu.app.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppUserDto(
    val name: String,
    val surname: String,
    val roleId: Long,
    val description: String? = null,
    val tgUserName: String? = null
)
