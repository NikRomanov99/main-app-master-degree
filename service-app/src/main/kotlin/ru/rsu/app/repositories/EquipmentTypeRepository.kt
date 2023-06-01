package ru.rsu.app.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jooq.DSLContext
import ru.rsu.app.database.generated.tables.daos.EquipmentTypeDao
import ru.rsu.app.database.generated.tables.pojos.EquipmentType
import ru.rsu.app.database.generated.tables.references.EQUIPMENT_TYPE
import ru.rsu.app.dto.response.EquipmentTypeResponseDto

class EquipmentTypeRepository(private val dslContext: DSLContext) {
    private val equipmentTypeDao = EquipmentTypeDao(dslContext.configuration())

    suspend fun selectEquipmentTypes(): List<EquipmentTypeResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(EQUIPMENT_TYPE.fields().toList())
                .from(EQUIPMENT_TYPE)
                .fetchInto(EquipmentTypeResponseDto::class.java)
        }

    suspend fun selectEquipmentTypeById(id: Long): List<EquipmentTypeResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(EQUIPMENT_TYPE.fields().toList())
                .from(EQUIPMENT_TYPE)
                .where(EQUIPMENT_TYPE.ID.eq(id))
                .fetchInto(EquipmentTypeResponseDto::class.java)
        }

    suspend fun insertEquipmentType(equipmentType: EquipmentType) =
        withContext(Dispatchers.IO) {
            equipmentTypeDao.insert(equipmentType)
        }

    suspend fun updateEquipmentType(equipmentType: EquipmentType) =
        withContext(Dispatchers.IO) {
            equipmentTypeDao.update(equipmentType)
        }

    suspend fun deleteEquipmentTypeById(id: Long) =
        withContext(Dispatchers.IO) {
            dslContext.delete(EQUIPMENT_TYPE).where(EQUIPMENT_TYPE.ID.eq(id))
        }
}
