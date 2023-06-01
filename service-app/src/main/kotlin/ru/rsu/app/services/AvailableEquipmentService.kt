package ru.rsu.app.services

import ru.rsu.app.database.generated.tables.pojos.AvailableEquipment
import ru.rsu.app.dto.AvailableEquipmentDto
import ru.rsu.app.dto.msg.LastInspectionMsg
import ru.rsu.app.dto.response.AvailableEquipmentResponseDto
import ru.rsu.app.repositories.AppUserRepository
import ru.rsu.app.repositories.AvailableEquipmentRepository
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AvailableEquipmentService(
    private val availableEquipmentRepository: AvailableEquipmentRepository,
    private val appUserRepository: AppUserRepository
) {

    suspend fun findListAllAvailableEquipment(): List<AvailableEquipmentResponseDto> {
        return availableEquipmentRepository.selectAvailableEquipments()
    }

    suspend fun findAvailableEquipmentById(id: Long): List<AvailableEquipmentResponseDto> {
        return availableEquipmentRepository.selectAvailableEquipmentById(id)
    }

    suspend fun addAvailableEquipment(body: AvailableEquipmentDto) {
        val availableEquipment = AvailableEquipment(
            rEquipmentId = body.equipmentId, description = body.description,
            lastTechInspectionDate = LocalDateTime.parse(body.lastInspectionDate.toString()),
            rLastInspectionUserId = body.userId, rFactoryId = body.factoryId
        )
        availableEquipmentRepository.insertAvailableEquipment(availableEquipment)
    }

    suspend fun updateAvailableEquipment(body: AvailableEquipmentDto, id: Long) {
        val availableEquipmentInDb = findAvailableEquipmentById(id)
        if (availableEquipmentInDb.isNotEmpty()) {
            val availableEquipment = AvailableEquipment(
                id = id, rEquipmentId = body.equipmentId, description = body.description,
                lastTechInspectionDate = LocalDateTime.parse(body.lastInspectionDate.toString()),
                rLastInspectionUserId = body.userId, rFactoryId = body.factoryId
            )
            availableEquipmentRepository.updateAvailableEquipment(availableEquipment)
        }
    }

    suspend fun deleteAvailableEquipment(id: Long) {
        availableEquipmentRepository.deleteAvailableEquipmentById(id)
    }

    suspend fun updateLastInspectionDate(lastInspectionMsg: LastInspectionMsg) {
        val availableEquipments = availableEquipmentRepository
            .selectAvailableEquipmentById(lastInspectionMsg.equipmentId)

        val appUserInfo = appUserRepository
            .selectAppUserByTgUserName(lastInspectionMsg.tgUserName)

        if (!availableEquipments.isEmpty() && !appUserInfo.isEmpty()) {
            availableEquipmentRepository.updateAvailableEquipmentByMsg(
                lastInspectionMsg.equipmentId,
                appUserInfo.first().id,
                LocalDateTime.parse(lastInspectionMsg.lastInspectionDate)
            )
        }
    }
}