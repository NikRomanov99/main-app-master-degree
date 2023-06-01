package ru.rsu.app.services

import ru.rsu.app.database.generated.tables.pojos.Role
import ru.rsu.app.dto.RoleDto
import ru.rsu.app.dto.response.RoleResponseDto
import ru.rsu.app.repositories.RoleRepository

class RoleService(private val roleRepository: RoleRepository) {

    suspend fun findListAllRole(): List<RoleResponseDto> {
        return roleRepository.selectRoles()
    }

    suspend fun findRoleById(id: Long): List<RoleResponseDto> {
        return roleRepository.selectRoleById(id)
    }

    suspend fun addRole(body: RoleDto) {
        val role = Role(name = body.name, description = body.description)
        roleRepository.insertRole(role)
    }

    suspend fun updateRole(body: RoleDto, id: Long) {
        val roleInDb = findRoleById(id)
        if (roleInDb.isNotEmpty()) {
            val role = Role(id = id, name = body.name, description = body.description)
            roleRepository.updateRole(role)
        }
    }

    suspend fun deleteRole(id: Long) {
        roleRepository.deleteRoleById(id)
    }
}