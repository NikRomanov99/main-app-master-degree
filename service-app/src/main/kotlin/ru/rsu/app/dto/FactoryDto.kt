package ru.rsu.app.dto

import kotlinx.serialization.Serializable

@Serializable
data class FactoryDto(val name: String, val companyName: String? = null, val address: String? = null)
