package ru.rsu.app.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class StandardResponseDto(val SUCCESS: Boolean, val CODE: Int)
