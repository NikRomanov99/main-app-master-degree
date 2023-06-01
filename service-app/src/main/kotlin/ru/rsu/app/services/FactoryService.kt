package ru.rsu.app.services

import ru.rsu.app.database.generated.tables.pojos.Factory
import ru.rsu.app.dto.FactoryDto
import ru.rsu.app.dto.response.FactoryResponseDto
import ru.rsu.app.repositories.FactoryRepository

class FactoryService(private val factoryRepository: FactoryRepository) {
    suspend fun findListAllFactory(): List<FactoryResponseDto> {
        return factoryRepository.selectFactories()
    }

    suspend fun findFactoryById(id: Long): List<FactoryResponseDto> {
        return factoryRepository.selectFactoryById(id)
    }

    suspend fun addFactory(body: FactoryDto) {
        val factory = Factory(name = body.name, companyName = body.companyName, address = body.address)
        factoryRepository.insertFactory(factory)
    }

    suspend fun updateFactory(body: FactoryDto, id: Long) {
        val factoryInDb = findFactoryById(id)
        if (factoryInDb.isNotEmpty()) {
            val factory = Factory(id = id, name = body.name, companyName = body.companyName, address = body.address)
            factoryRepository.updateFactory(factory)
        }
    }

    suspend fun deleteFactory(id: Long) {
        factoryRepository.deleteFactoryById(id)
    }
}