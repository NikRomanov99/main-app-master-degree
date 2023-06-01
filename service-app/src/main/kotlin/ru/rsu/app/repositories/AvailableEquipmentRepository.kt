package ru.rsu.app.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jooq.DSLContext
import ru.rsu.app.database.generated.tables.daos.AvailableEquipmentDao
import ru.rsu.app.database.generated.tables.pojos.AvailableEquipment
import ru.rsu.app.database.generated.tables.references.APP_USER
import ru.rsu.app.database.generated.tables.references.AVAILABLE_EQUIPMENT
import ru.rsu.app.database.generated.tables.references.EQUIPMENT
import ru.rsu.app.database.generated.tables.references.FACTORY
import ru.rsu.app.dto.response.AvailableEquipmentResponseDto
import java.time.LocalDateTime

class AvailableEquipmentRepository(private val dslContext: DSLContext) {
    private val availableEquipmentDao = AvailableEquipmentDao(dslContext.configuration())

    suspend fun selectAvailableEquipments(): List<AvailableEquipmentResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(
                AVAILABLE_EQUIPMENT.ID,
                EQUIPMENT.NAME.`as`("equipmentName"),
                AVAILABLE_EQUIPMENT.DESCRIPTION,
                AVAILABLE_EQUIPMENT.LAST_TECH_INSPECTION_DATE.`as`("lastInspectionDate"),
                APP_USER.NAME.`as`("userName"),
                APP_USER.SURNAME.`as`("userSurname"),
                FACTORY.NAME.`as`("factoryName")
            )
                .from(AVAILABLE_EQUIPMENT)
                .leftJoin(EQUIPMENT)
                .on(AVAILABLE_EQUIPMENT.R_EQUIPMENT_ID.eq(EQUIPMENT.ID))
                .leftJoin(APP_USER)
                .on(AVAILABLE_EQUIPMENT.R_LAST_INSPECTION_USER_ID.eq(APP_USER.ID))
                .leftJoin(FACTORY)
                .on(AVAILABLE_EQUIPMENT.R_FACTORY_ID.eq(FACTORY.ID))
                .fetchInto(AvailableEquipmentResponseDto::class.java)
        }

    suspend fun selectAvailableEquipmentById(id: Long): List<AvailableEquipmentResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(
                AVAILABLE_EQUIPMENT.ID,
                EQUIPMENT.NAME.`as`("equipmentName"),
                AVAILABLE_EQUIPMENT.DESCRIPTION,
                AVAILABLE_EQUIPMENT.LAST_TECH_INSPECTION_DATE.`as`("lastInspectionDate"),
                APP_USER.NAME.`as`("userName"),
                APP_USER.SURNAME.`as`("userSurname"),
                FACTORY.NAME.`as`("factoryName")
            )
                .from(AVAILABLE_EQUIPMENT)
                .leftJoin(EQUIPMENT)
                .on(AVAILABLE_EQUIPMENT.R_EQUIPMENT_ID.eq(EQUIPMENT.ID))
                .leftJoin(APP_USER)
                .on(AVAILABLE_EQUIPMENT.R_LAST_INSPECTION_USER_ID.eq(APP_USER.ID))
                .leftJoin(FACTORY)
                .on(AVAILABLE_EQUIPMENT.R_FACTORY_ID.eq(FACTORY.ID))
                .where(AVAILABLE_EQUIPMENT.ID.eq(id))
                .fetchInto(AvailableEquipmentResponseDto::class.java)
        }

    suspend fun insertAvailableEquipment(availableEquipment: AvailableEquipment) =
        withContext(Dispatchers.IO) {
            availableEquipmentDao.insert(availableEquipment)
        }

    suspend fun updateAvailableEquipment(availableEquipment: AvailableEquipment) =
        withContext(Dispatchers.IO) {
            availableEquipmentDao.update(availableEquipment)
        }

    suspend fun updateAvailableEquipmentByMsg(id: Long, userId: Long, lastInspectionDate: LocalDateTime) =
        withContext(Dispatchers.IO) {
            dslContext.update(AVAILABLE_EQUIPMENT)
                .set(AVAILABLE_EQUIPMENT.LAST_TECH_INSPECTION_DATE, lastInspectionDate)
                .set(AVAILABLE_EQUIPMENT.R_LAST_INSPECTION_USER_ID, userId)
                .where(AVAILABLE_EQUIPMENT.ID.eq(id)).execute()
        }

    suspend fun deleteAvailableEquipmentById(id: Long) =
        withContext(Dispatchers.IO) {
            dslContext.delete(AVAILABLE_EQUIPMENT).where(AVAILABLE_EQUIPMENT.ID.eq(id))
        }
}