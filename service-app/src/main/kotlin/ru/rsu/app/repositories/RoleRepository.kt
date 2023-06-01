package ru.rsu.app.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jooq.DSLContext
import ru.rsu.app.database.generated.tables.daos.RoleDao
import ru.rsu.app.database.generated.tables.pojos.Role
import ru.rsu.app.database.generated.tables.references.ROLE
import ru.rsu.app.dto.response.RoleResponseDto

class RoleRepository(private val dslContext: DSLContext) {
    private val roleDao = RoleDao(dslContext.configuration())
    suspend fun selectRoles(): List<RoleResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(ROLE.fields().toList())
                .from(ROLE)
                .fetchInto(RoleResponseDto::class.java)
        }

    suspend fun selectRoleById(id: Long): List<RoleResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(ROLE.fields().toList())
                .from(ROLE)
                .where(ROLE.ID.eq(id))
                .fetchInto(RoleResponseDto::class.java)
        }

    suspend fun insertRole(factory: Role) =
        withContext(Dispatchers.IO) {
            roleDao.insert(factory)
        }

    suspend fun updateRole(factory: Role) =
        withContext(Dispatchers.IO) {
            roleDao.update(factory)
        }

    suspend fun deleteRoleById(id: Long) =
        withContext(Dispatchers.IO) {
            dslContext.delete(ROLE).where(ROLE.ID.eq(id))
        }
}