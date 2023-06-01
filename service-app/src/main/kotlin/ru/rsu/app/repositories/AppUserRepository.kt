package ru.rsu.app.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jooq.DSLContext
import ru.rsu.app.database.generated.tables.AppUser.Companion.APP_USER
import ru.rsu.app.database.generated.tables.daos.AppUserDao
import ru.rsu.app.database.generated.tables.pojos.AppUser
import ru.rsu.app.database.generated.tables.references.ROLE
import ru.rsu.app.dto.response.AppUserResponseDto

class AppUserRepository(private val dslContext: DSLContext) {
    private val appUserDao = AppUserDao(dslContext.configuration())

    suspend fun selectAppUsers(): List<AppUserResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(
                APP_USER.ID,
                APP_USER.NAME,
                APP_USER.SURNAME,
                ROLE.NAME.`as`("roleDescription"),
                APP_USER.DESCRIPTION,
                APP_USER.TG_USER_NAME.`as`("tgUserName")
            )
                .from(APP_USER)
                .leftJoin(ROLE).on(APP_USER.R_ROLE_ID.eq(ROLE.ID))
                .fetchInto(AppUserResponseDto::class.java)
        }

    suspend fun selectAppUserById(id: Long): List<AppUserResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(
                APP_USER.ID,
                APP_USER.NAME,
                APP_USER.SURNAME,
                ROLE.NAME.`as`("roleDescription"),
                APP_USER.DESCRIPTION,
                APP_USER.TG_USER_NAME.`as`("tgUserName")
            )
                .from(APP_USER)
                .leftJoin(ROLE).on(APP_USER.R_ROLE_ID.eq(ROLE.ID))
                .where(APP_USER.ID.eq(id))
                .fetchInto(AppUserResponseDto::class.java)
        }

    suspend fun selectAppUserById(tgUserName: String): List<AppUserResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(
                APP_USER.ID,
                APP_USER.NAME,
                APP_USER.SURNAME,
                ROLE.NAME.`as`("roleDescription"),
                APP_USER.DESCRIPTION,
                APP_USER.TG_USER_NAME.`as`("tgUserName")
            )
                .from(APP_USER)
                .leftJoin(ROLE).on(APP_USER.R_ROLE_ID.eq(ROLE.ID))
                .where(APP_USER.TG_USER_NAME.eq(tgUserName))
                .fetchInto(AppUserResponseDto::class.java)
        }

    suspend fun selectAppUserByTgUserName(tgUserName: String): List<AppUserResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(
                APP_USER.ID,
                APP_USER.NAME,
                APP_USER.SURNAME,
                ROLE.NAME.`as`("roleDescription"),
                APP_USER.DESCRIPTION,
                APP_USER.TG_USER_NAME.`as`("tgUserName")
            )
                .from(APP_USER)
                .leftJoin(ROLE).on(APP_USER.R_ROLE_ID.eq(ROLE.ID))
                .where(APP_USER.TG_USER_NAME.eq(tgUserName))
                .fetchInto(AppUserResponseDto::class.java)
        }

    suspend fun insertAppUser(appUser: AppUser) =
        withContext(Dispatchers.IO) {
            appUserDao.insert(appUser)
        }

    suspend fun updateAppUser(appUser: AppUser) =
        withContext(Dispatchers.IO) {
            appUserDao.update(appUser)
        }

    suspend fun deleteAppUserById(id: Long) =
        withContext(Dispatchers.IO) {
            dslContext.delete(APP_USER).where(APP_USER.ID.eq(id))
        }
}