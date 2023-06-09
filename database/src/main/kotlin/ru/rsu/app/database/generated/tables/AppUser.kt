/*
 * This file is generated by jOOQ.
 */
package ru.rsu.app.database.generated.tables


import java.util.function.Function

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row6
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl

import ru.rsu.app.database.generated.Public
import ru.rsu.app.database.generated.keys.APP_USER_PKEY
import ru.rsu.app.database.generated.keys.APP_USER__FK_USER_ROLE_ID
import ru.rsu.app.database.generated.tables.records.AppUserRecord


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class AppUser(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, AppUserRecord>?,
    aliased: Table<AppUserRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<AppUserRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>public.app_user</code>
         */
        val APP_USER: AppUser = AppUser()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<AppUserRecord> = AppUserRecord::class.java

    /**
     * The column <code>public.app_user.id</code>.
     */
    val ID: TableField<AppUserRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.app_user.name</code>.
     */
    val NAME: TableField<AppUserRecord, String?> = createField(DSL.name("name"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>public.app_user.surname</code>.
     */
    val SURNAME: TableField<AppUserRecord, String?> = createField(DSL.name("surname"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>public.app_user.r_role_id</code>.
     */
    val R_ROLE_ID: TableField<AppUserRecord, Long?> = createField(DSL.name("r_role_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.app_user.description</code>.
     */
    val DESCRIPTION: TableField<AppUserRecord, String?> = createField(DSL.name("description"), SQLDataType.CLOB, this, "")

    /**
     * The column <code>public.app_user.tg_user_name</code>.
     */
    val TG_USER_NAME: TableField<AppUserRecord, String?> = createField(DSL.name("tg_user_name"), SQLDataType.CLOB, this, "")

    private constructor(alias: Name, aliased: Table<AppUserRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<AppUserRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.app_user</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.app_user</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.app_user</code> table reference
     */
    constructor(): this(DSL.name("app_user"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, AppUserRecord>): this(Internal.createPathAlias(child, key), child, key, APP_USER, null)
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<AppUserRecord, Long?> = super.getIdentity() as Identity<AppUserRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<AppUserRecord> = APP_USER_PKEY
    override fun getReferences(): List<ForeignKey<AppUserRecord, *>> = listOf(APP_USER__FK_USER_ROLE_ID)

    private lateinit var _role: Role

    /**
     * Get the implicit join path to the <code>public.role</code> table.
     */
    fun role(): Role {
        if (!this::_role.isInitialized)
            _role = Role(this, APP_USER__FK_USER_ROLE_ID)

        return _role;
    }

    val role: Role
        get(): Role = role()
    override fun `as`(alias: String): AppUser = AppUser(DSL.name(alias), this)
    override fun `as`(alias: Name): AppUser = AppUser(alias, this)
    override fun `as`(alias: Table<*>): AppUser = AppUser(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): AppUser = AppUser(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): AppUser = AppUser(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): AppUser = AppUser(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row6<Long?, String?, String?, Long?, String?, String?> = super.fieldsRow() as Row6<Long?, String?, String?, Long?, String?, String?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Long?, String?, String?, Long?, String?, String?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Long?, String?, String?, Long?, String?, String?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
