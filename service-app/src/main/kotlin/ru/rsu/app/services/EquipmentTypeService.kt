package ru.rsu.app.services

import ru.rsu.app.database.generated.tables.pojos.EquipmentType
import ru.rsu.app.dto.EquipmentTypeDto
import ru.rsu.app.dto.response.EquipmentTypeResponseDto
import ru.rsu.app.repositories.EquipmentTypeRepository

class EquipmentTypeService(private val equipmentTypeRepository: EquipmentTypeRepository) {

    suspend fun findListAllEquipmentType(): List<EquipmentTypeResponseDto> {
        return equipmentTypeRepository.selectEquipmentTypes()
    }

    suspend fun findEquipmentTypeById(id: Long): List<EquipmentTypeResponseDto> {
        return equipmentTypeRepository.selectEquipmentTypeById(id)
    }

    suspend fun addEquipmentType(body: EquipmentTypeDto) {
        val equipmentType = EquipmentType(name = body.name, description = body.description)
        equipmentTypeRepository.insertEquipmentType(equipmentType)
    }

    suspend fun updateEquipmentType(body: EquipmentTypeDto, id: Long) {
        val equipmentTypeInDb = findEquipmentTypeById(id)
        if (equipmentTypeInDb.isNotEmpty()) {
            val equipmentType = EquipmentType(id = id, name = body.name, description = body.description)
            equipmentTypeRepository.updateEquipmentType(equipmentType)
        }
    }

    suspend fun deleteEquipmentType(id: Long) {
        equipmentTypeRepository.deleteEquipmentTypeById(id)
    }
}
