package ru.rsu.app.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jooq.DSLContext
import ru.rsu.app.database.generated.tables.Factory.Companion.FACTORY
import ru.rsu.app.database.generated.tables.daos.FactoryDao
import ru.rsu.app.database.generated.tables.pojos.Factory
import ru.rsu.app.dto.response.FactoryResponseDto

class FactoryRepository(private val dslContext: DSLContext) {
    private val factoryDao = FactoryDao(dslContext.configuration())

    suspend fun selectFactories(): List<FactoryResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(FACTORY.fields().toList())
                .from(FACTORY)
                .fetchInto(FactoryResponseDto::class.java)
        }

    suspend fun selectFactoryById(id: Long): List<FactoryResponseDto> =
        withContext(Dispatchers.IO) {
            dslContext.select(FACTORY.fields().toList())
                .from(FACTORY)
                .where(FACTORY.ID.eq(id))
                .fetchInto(FactoryResponseDto::class.java)
        }

    suspend fun insertFactory(factory: Factory) =
        withContext(Dispatchers.IO) {
            factoryDao.insert(factory)
        }

    suspend fun updateFactory(factory: Factory) =
        withContext(Dispatchers.IO) {
            factoryDao.update(factory)
        }

    suspend fun deleteFactoryById(id: Long) =
        withContext(Dispatchers.IO) {
            dslContext.delete(FACTORY).where(FACTORY.ID.eq(id))
        }
}