package ru.rsu.app.services

import ru.rsu.app.database.generated.tables.pojos.Equipment
import ru.rsu.app.dto.EquipmentDto
import ru.rsu.app.dto.response.EquipmentResponseDto
import ru.rsu.app.repositories.EquipmentRepository
import java.time.LocalDateTime

class EquipmentService(private val equipmentRepository: EquipmentRepository) {

    suspend fun findListAllEquipment(): List<EquipmentResponseDto> {
        return equipmentRepository.selectEquipments()
    }

    suspend fun findEquipmentById(id: Long): List<EquipmentResponseDto> {
        return equipmentRepository.selectEquipmentById(id)
    }

    suspend fun addEquipment(body: EquipmentDto) {
        val equipment = Equipment(
            name = body.name, rEquipmentTypeId = body.equipmentTypeId,
            serviceLifeYear = body.serviceLifeInYear, manufacture = body.manufacture,
            manufactureDate = LocalDateTime.parse(body.manufactureDate.toString()),
            serialNumber = body.serialNumber
        )
        equipmentRepository.insertEquipment(equipment)
    }

    suspend fun updateEquipment(body: EquipmentDto, id: Long) {
        val equipmentInDb = findEquipmentById(id)
        if (equipmentInDb.isNotEmpty()) {
            val equipment = Equipment(
                id = id, name = body.name, rEquipmentTypeId = body.equipmentTypeId,
                serviceLifeYear = body.serviceLifeInYear, manufacture = body.manufacture,
                manufactureDate = LocalDateTime.parse(body.manufactureDate.toString()),
                serialNumber = body.serialNumber
            )
            equipmentRepository.updateEquipment(equipment)
        }
    }

    suspend fun deleteEquipment(id: Long) {
        equipmentRepository.deleteEquipmentById(id)
    }
}
