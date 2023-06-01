package ru.rsu.app.dto.msg

import kotlinx.serialization.Serializable

@Serializable
data class LastInspectionMsg(val equipmentId: Long, val tgUserName: String, val lastInspectionDate: String)
