/*
 * This file is generated by jOOQ.
 */
package ru.rsu.app.database.generated.tables.daos


import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.impl.DAOImpl

import ru.rsu.app.database.generated.tables.Role
import ru.rsu.app.database.generated.tables.records.RoleRecord


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class RoleDao(configuration: Configuration?) : DAOImpl<RoleRecord, ru.rsu.app.database.generated.tables.pojos.Role, Long>(Role.ROLE, ru.rsu.app.database.generated.tables.pojos.Role::class.java, configuration) {

    /**
     * Create a new RoleDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: ru.rsu.app.database.generated.tables.pojos.Role): Long? = o.id

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfId(lowerInclusive: Long?, upperInclusive: Long?): List<ru.rsu.app.database.generated.tables.pojos.Role> = fetchRange(Role.ROLE.ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    fun fetchById(vararg values: Long): List<ru.rsu.app.database.generated.tables.pojos.Role> = fetch(Role.ROLE.ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    fun fetchOneById(value: Long): ru.rsu.app.database.generated.tables.pojos.Role? = fetchOne(Role.ROLE.ID, value)

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfName(lowerInclusive: String?, upperInclusive: String?): List<ru.rsu.app.database.generated.tables.pojos.Role> = fetchRange(Role.ROLE.NAME, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    fun fetchByName(vararg values: String): List<ru.rsu.app.database.generated.tables.pojos.Role> = fetch(Role.ROLE.NAME, *values)

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfDescription(lowerInclusive: String?, upperInclusive: String?): List<ru.rsu.app.database.generated.tables.pojos.Role> = fetchRange(Role.ROLE.DESCRIPTION, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    fun fetchByDescription(vararg values: String): List<ru.rsu.app.database.generated.tables.pojos.Role> = fetch(Role.ROLE.DESCRIPTION, *values)
}