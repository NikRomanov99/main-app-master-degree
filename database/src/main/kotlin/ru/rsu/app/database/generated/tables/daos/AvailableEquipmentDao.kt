/*
 * This file is generated by jOOQ.
 */
package ru.rsu.app.database.generated.tables.daos


import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.impl.DAOImpl

import ru.rsu.app.database.generated.tables.AvailableEquipment
import ru.rsu.app.database.generated.tables.records.AvailableEquipmentRecord


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class AvailableEquipmentDao(configuration: Configuration?) : DAOImpl<AvailableEquipmentRecord, ru.rsu.app.database.generated.tables.pojos.AvailableEquipment, Long>(AvailableEquipment.AVAILABLE_EQUIPMENT, ru.rsu.app.database.generated.tables.pojos.AvailableEquipment::class.java, configuration) {

    /**
     * Create a new AvailableEquipmentDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: ru.rsu.app.database.generated.tables.pojos.AvailableEquipment): Long? = o.id

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfId(lowerInclusive: Long?, upperInclusive: Long?): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetchRange(AvailableEquipment.AVAILABLE_EQUIPMENT.ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    fun fetchById(vararg values: Long): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetch(AvailableEquipment.AVAILABLE_EQUIPMENT.ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    fun fetchOneById(value: Long): ru.rsu.app.database.generated.tables.pojos.AvailableEquipment? = fetchOne(AvailableEquipment.AVAILABLE_EQUIPMENT.ID, value)

    /**
     * Fetch records that have <code>r_equipment_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfREquipmentId(lowerInclusive: Long?, upperInclusive: Long?): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetchRange(AvailableEquipment.AVAILABLE_EQUIPMENT.R_EQUIPMENT_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>r_equipment_id IN (values)</code>
     */
    fun fetchByREquipmentId(vararg values: Long): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetch(AvailableEquipment.AVAILABLE_EQUIPMENT.R_EQUIPMENT_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfDescription(lowerInclusive: String?, upperInclusive: String?): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetchRange(AvailableEquipment.AVAILABLE_EQUIPMENT.DESCRIPTION, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    fun fetchByDescription(vararg values: String): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetch(AvailableEquipment.AVAILABLE_EQUIPMENT.DESCRIPTION, *values)

    /**
     * Fetch records that have <code>last_tech_inspection_date BETWEEN
     * lowerInclusive AND upperInclusive</code>
     */
    fun fetchRangeOfLastTechInspectionDate(lowerInclusive: LocalDateTime?, upperInclusive: LocalDateTime?): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetchRange(AvailableEquipment.AVAILABLE_EQUIPMENT.LAST_TECH_INSPECTION_DATE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>last_tech_inspection_date IN
     * (values)</code>
     */
    fun fetchByLastTechInspectionDate(vararg values: LocalDateTime): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetch(AvailableEquipment.AVAILABLE_EQUIPMENT.LAST_TECH_INSPECTION_DATE, *values)

    /**
     * Fetch records that have <code>r_last_inspection_user_id BETWEEN
     * lowerInclusive AND upperInclusive</code>
     */
    fun fetchRangeOfRLastInspectionUserId(lowerInclusive: Long?, upperInclusive: Long?): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetchRange(AvailableEquipment.AVAILABLE_EQUIPMENT.R_LAST_INSPECTION_USER_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>r_last_inspection_user_id IN
     * (values)</code>
     */
    fun fetchByRLastInspectionUserId(vararg values: Long): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetch(AvailableEquipment.AVAILABLE_EQUIPMENT.R_LAST_INSPECTION_USER_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>r_factory_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfRFactoryId(lowerInclusive: Long?, upperInclusive: Long?): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetchRange(AvailableEquipment.AVAILABLE_EQUIPMENT.R_FACTORY_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>r_factory_id IN (values)</code>
     */
    fun fetchByRFactoryId(vararg values: Long): List<ru.rsu.app.database.generated.tables.pojos.AvailableEquipment> = fetch(AvailableEquipment.AVAILABLE_EQUIPMENT.R_FACTORY_ID, *values.toTypedArray())
}