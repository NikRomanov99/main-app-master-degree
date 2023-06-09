/*
 * This file is generated by jOOQ.
 */
package ru.rsu.app.database.generated.tables.pojos


import java.io.Serializable
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Equipment(
    var id: Long? = null,
    var name: String? = null,
    var rEquipmentTypeId: Long? = null,
    var serviceLifeYear: Int? = null,
    var manufacture: String? = null,
    var manufactureDate: LocalDateTime? = null,
    var serialNumber: String? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: Equipment = other as Equipment
        if (this.id == null) {
            if (o.id != null)
                return false
        }
        else if (this.id != o.id)
            return false
        if (this.name == null) {
            if (o.name != null)
                return false
        }
        else if (this.name != o.name)
            return false
        if (this.rEquipmentTypeId == null) {
            if (o.rEquipmentTypeId != null)
                return false
        }
        else if (this.rEquipmentTypeId != o.rEquipmentTypeId)
            return false
        if (this.serviceLifeYear == null) {
            if (o.serviceLifeYear != null)
                return false
        }
        else if (this.serviceLifeYear != o.serviceLifeYear)
            return false
        if (this.manufacture == null) {
            if (o.manufacture != null)
                return false
        }
        else if (this.manufacture != o.manufacture)
            return false
        if (this.manufactureDate == null) {
            if (o.manufactureDate != null)
                return false
        }
        else if (this.manufactureDate != o.manufactureDate)
            return false
        if (this.serialNumber == null) {
            if (o.serialNumber != null)
                return false
        }
        else if (this.serialNumber != o.serialNumber)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.id == null) 0 else this.id.hashCode())
        result = prime * result + (if (this.name == null) 0 else this.name.hashCode())
        result = prime * result + (if (this.rEquipmentTypeId == null) 0 else this.rEquipmentTypeId.hashCode())
        result = prime * result + (if (this.serviceLifeYear == null) 0 else this.serviceLifeYear.hashCode())
        result = prime * result + (if (this.manufacture == null) 0 else this.manufacture.hashCode())
        result = prime * result + (if (this.manufactureDate == null) 0 else this.manufactureDate.hashCode())
        result = prime * result + (if (this.serialNumber == null) 0 else this.serialNumber.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("Equipment (")

        sb.append(id)
        sb.append(", ").append(name)
        sb.append(", ").append(rEquipmentTypeId)
        sb.append(", ").append(serviceLifeYear)
        sb.append(", ").append(manufacture)
        sb.append(", ").append(manufactureDate)
        sb.append(", ").append(serialNumber)

        sb.append(")")
        return sb.toString()
    }
}
