/*
 * This file is generated by jOOQ.
 */
package ru.rsu.app.database.generated.tables.daos


import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.impl.DAOImpl

import ru.rsu.app.database.generated.tables.AppUser
import ru.rsu.app.database.generated.tables.records.AppUserRecord


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class AppUserDao(configuration: Configuration?) : DAOImpl<AppUserRecord, ru.rsu.app.database.generated.tables.pojos.AppUser, Long>(AppUser.APP_USER, ru.rsu.app.database.generated.tables.pojos.AppUser::class.java, configuration) {

    /**
     * Create a new AppUserDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: ru.rsu.app.database.generated.tables.pojos.AppUser): Long? = o.id

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfId(lowerInclusive: Long?, upperInclusive: Long?): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetchRange(AppUser.APP_USER.ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    fun fetchById(vararg values: Long): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetch(AppUser.APP_USER.ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    fun fetchOneById(value: Long): ru.rsu.app.database.generated.tables.pojos.AppUser? = fetchOne(AppUser.APP_USER.ID, value)

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfName(lowerInclusive: String?, upperInclusive: String?): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetchRange(AppUser.APP_USER.NAME, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    fun fetchByName(vararg values: String): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetch(AppUser.APP_USER.NAME, *values)

    /**
     * Fetch records that have <code>surname BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfSurname(lowerInclusive: String?, upperInclusive: String?): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetchRange(AppUser.APP_USER.SURNAME, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>surname IN (values)</code>
     */
    fun fetchBySurname(vararg values: String): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetch(AppUser.APP_USER.SURNAME, *values)

    /**
     * Fetch records that have <code>r_role_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfRRoleId(lowerInclusive: Long?, upperInclusive: Long?): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetchRange(AppUser.APP_USER.R_ROLE_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>r_role_id IN (values)</code>
     */
    fun fetchByRRoleId(vararg values: Long): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetch(AppUser.APP_USER.R_ROLE_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfDescription(lowerInclusive: String?, upperInclusive: String?): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetchRange(AppUser.APP_USER.DESCRIPTION, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    fun fetchByDescription(vararg values: String): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetch(AppUser.APP_USER.DESCRIPTION, *values)

    /**
     * Fetch records that have <code>tg_user_name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfTgUserName(lowerInclusive: String?, upperInclusive: String?): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetchRange(AppUser.APP_USER.TG_USER_NAME, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>tg_user_name IN (values)</code>
     */
    fun fetchByTgUserName(vararg values: String): List<ru.rsu.app.database.generated.tables.pojos.AppUser> = fetch(AppUser.APP_USER.TG_USER_NAME, *values)
}