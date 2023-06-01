package ru.rsu.app.services

import ru.rsu.app.database.generated.tables.pojos.AppUser
import ru.rsu.app.dto.AppUserDto
import ru.rsu.app.dto.response.AppUserResponseDto
import ru.rsu.app.repositories.AppUserRepository

class AppUserService(private val appUserRepository: AppUserRepository) {
    suspend fun findListAllAppUser(): List<AppUserResponseDto> {
        return appUserRepository.selectAppUsers()
    }

    suspend fun findAppUserById(id: Long): List<AppUserResponseDto> {
        return appUserRepository.selectAppUserById(id)
    }

    suspend fun findAppUserByTgUserName(tgUserName: String): List<AppUserResponseDto> {
        return appUserRepository.selectAppUserById(tgUserName)
    }

    suspend fun addAppUser(body: AppUserDto) {
        val appUser = AppUser(
            name = body.name, surname = body.surname, rRoleId = body.roleId,
            description = body.description, tgUserName = body.tgUserName
        )
        appUserRepository.insertAppUser(appUser)
    }

    suspend fun updateAppUser(body: AppUserDto, id: Long) {
        val userInDb = findAppUserById(id)
        if (userInDb.isNotEmpty()) {
            val appUser = AppUser(
                id = id, name = body.name, surname = body.surname, rRoleId = body.roleId,
                description = body.description, tgUserName = body.tgUserName
            )
            appUserRepository.updateAppUser(appUser)
        }
    }

    suspend fun deleteAppUser(id: Long) {
        appUserRepository.deleteAppUserById(id)
    }
}