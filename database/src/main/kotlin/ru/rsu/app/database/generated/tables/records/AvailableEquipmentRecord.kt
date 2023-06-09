/*
 * This file is generated by jOOQ.
 */
package ru.rsu.app.database.generated.tables.records


import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record6
import org.jooq.Row6
import org.jooq.impl.UpdatableRecordImpl

import ru.rsu.app.database.generated.tables.AvailableEquipment


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class AvailableEquipmentRecord() : UpdatableRecordImpl<AvailableEquipmentRecord>(AvailableEquipment.AVAILABLE_EQUIPMENT), Record6<Long?, Long?, String?, LocalDateTime?, Long?, Long?> {

    open var id: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    open var rEquipmentId: Long?
        set(value): Unit = set(1, value)
        get(): Long? = get(1) as Long?

    open var description: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var lastTechInspectionDate: LocalDateTime?
        set(value): Unit = set(3, value)
        get(): LocalDateTime? = get(3) as LocalDateTime?

    open var rLastInspectionUserId: Long?
        set(value): Unit = set(4, value)
        get(): Long? = get(4) as Long?

    open var rFactoryId: Long?
        set(value): Unit = set(5, value)
        get(): Long? = get(5) as Long?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row6<Long?, Long?, String?, LocalDateTime?, Long?, Long?> = super.fieldsRow() as Row6<Long?, Long?, String?, LocalDateTime?, Long?, Long?>
    override fun valuesRow(): Row6<Long?, Long?, String?, LocalDateTime?, Long?, Long?> = super.valuesRow() as Row6<Long?, Long?, String?, LocalDateTime?, Long?, Long?>
    override fun field1(): Field<Long?> = AvailableEquipment.AVAILABLE_EQUIPMENT.ID
    override fun field2(): Field<Long?> = AvailableEquipment.AVAILABLE_EQUIPMENT.R_EQUIPMENT_ID
    override fun field3(): Field<String?> = AvailableEquipment.AVAILABLE_EQUIPMENT.DESCRIPTION
    override fun field4(): Field<LocalDateTime?> = AvailableEquipment.AVAILABLE_EQUIPMENT.LAST_TECH_INSPECTION_DATE
    override fun field5(): Field<Long?> = AvailableEquipment.AVAILABLE_EQUIPMENT.R_LAST_INSPECTION_USER_ID
    override fun field6(): Field<Long?> = AvailableEquipment.AVAILABLE_EQUIPMENT.R_FACTORY_ID
    override fun component1(): Long? = id
    override fun component2(): Long? = rEquipmentId
    override fun component3(): String? = description
    override fun component4(): LocalDateTime? = lastTechInspectionDate
    override fun component5(): Long? = rLastInspectionUserId
    override fun component6(): Long? = rFactoryId
    override fun value1(): Long? = id
    override fun value2(): Long? = rEquipmentId
    override fun value3(): String? = description
    override fun value4(): LocalDateTime? = lastTechInspectionDate
    override fun value5(): Long? = rLastInspectionUserId
    override fun value6(): Long? = rFactoryId

    override fun value1(value: Long?): AvailableEquipmentRecord {
        set(0, value)
        return this
    }

    override fun value2(value: Long?): AvailableEquipmentRecord {
        set(1, value)
        return this
    }

    override fun value3(value: String?): AvailableEquipmentRecord {
        set(2, value)
        return this
    }

    override fun value4(value: LocalDateTime?): AvailableEquipmentRecord {
        set(3, value)
        return this
    }

    override fun value5(value: Long?): AvailableEquipmentRecord {
        set(4, value)
        return this
    }

    override fun value6(value: Long?): AvailableEquipmentRecord {
        set(5, value)
        return this
    }

    override fun values(value1: Long?, value2: Long?, value3: String?, value4: LocalDateTime?, value5: Long?, value6: Long?): AvailableEquipmentRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        return this
    }

    /**
     * Create a detached, initialised AvailableEquipmentRecord
     */
    constructor(id: Long? = null, rEquipmentId: Long? = null, description: String? = null, lastTechInspectionDate: LocalDateTime? = null, rLastInspectionUserId: Long? = null, rFactoryId: Long? = null): this() {
        this.id = id
        this.rEquipmentId = rEquipmentId
        this.description = description
        this.lastTechInspectionDate = lastTechInspectionDate
        this.rLastInspectionUserId = rLastInspectionUserId
        this.rFactoryId = rFactoryId
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised AvailableEquipmentRecord
     */
    constructor(value: ru.rsu.app.database.generated.tables.pojos.AvailableEquipment?): this() {
        if (value != null) {
            this.id = value.id
            this.rEquipmentId = value.rEquipmentId
            this.description = value.description
            this.lastTechInspectionDate = value.lastTechInspectionDate
            this.rLastInspectionUserId = value.rLastInspectionUserId
            this.rFactoryId = value.rFactoryId
            resetChangedOnNotNull()
        }
    }
}
