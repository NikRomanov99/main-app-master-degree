package ru.rsu.app.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jooq.DSLContext
import ru.rsu.app.database.generated.tables.daos.EquipmentDao
import ru.rsu.app.database.generated.tables.pojos.Equipment
import ru.rsu.app.database.generated.tables.references.EQUIPMENT
import ru.rsu.app.database.generated.tables.references.EQUIPMENT_TYPE
import ru.rsu.app.dto.response.EquipmentResponseDto


class EquipmentRepository(private val dslContext: DSLContext) {
    private val equipmentDao = EquipmentDao(dslContext.configuration())

    suspend fun selectEquipments(): List<EquipmentResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(
                EQUIPMENT.ID,
                EQUIPMENT.NAME,
                EQUIPMENT_TYPE.NAME.`as`("equipmentType"),
                EQUIPMENT.SERVICE_LIFE_YEAR.`as`("serviceLifeInYear"),
                EQUIPMENT.MANUFACTURE,
                EQUIPMENT.MANUFACTURE_DATE.`as`("manufactureDate"),
                EQUIPMENT.SERIAL_NUMBER
            )
                .from(EQUIPMENT)
                .leftJoin(EQUIPMENT_TYPE).on(EQUIPMENT.R_EQUIPMENT_TYPE_ID.eq(EQUIPMENT_TYPE.ID))
                .fetchInto(EquipmentResponseDto::class.java)
        }

    suspend fun selectEquipmentById(id: Long): List<EquipmentResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(
                EQUIPMENT.ID,
                EQUIPMENT.NAME,
                EQUIPMENT_TYPE.NAME.`as`("equipmentType"),
                EQUIPMENT.SERVICE_LIFE_YEAR.`as`("serviceLifeInYear"),
                EQUIPMENT.MANUFACTURE,
                EQUIPMENT.MANUFACTURE_DATE.`as`("manufactureDate"),
                EQUIPMENT.SERIAL_NUMBER
            )
                .from(EQUIPMENT)
                .leftJoin(EQUIPMENT_TYPE).on(EQUIPMENT.R_EQUIPMENT_TYPE_ID.eq(EQUIPMENT_TYPE.ID))
                .where(EQUIPMENT.ID.eq(id))
                .fetchInto(EquipmentResponseDto::class.java)
        }

    suspend fun insertEquipment(equipment: Equipment) =
        withContext(Dispatchers.IO) {
            equipmentDao.insert(equipment)
        }

    suspend fun updateEquipment(equipment: Equipment) =
        withContext(Dispatchers.IO) {
            equipmentDao.update(equipment)
        }

    suspend fun deleteEquipmentById(id: Long) =
        withContext(Dispatchers.IO) {
            dslContext.delete(EQUIPMENT).where(EQUIPMENT.ID.eq(id))
        }
}