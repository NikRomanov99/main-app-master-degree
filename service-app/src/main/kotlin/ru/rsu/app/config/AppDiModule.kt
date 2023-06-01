package ru.rsu.app.config

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import io.ktor.server.config.*
import org.jooq.DSLContext
import org.koin.dsl.module
import ru.rsu.app.repositories.*
import ru.rsu.app.services.*
import ru.rsu.app.services.kafka.KafkaConsumer
import ru.rsu.app.utils.PropertyConfigUtils

val appModule = module {
    single<DataSourceConfig> {
        val applicationConfig = HoconApplicationConfig(ConfigFactory.load())
        DataSourceConfig.createDataSourceConfig(applicationConfig)
    }

    single<HikariDataSource> {
        DataSourceConfig.createDataSource(get())
    }

    single<DSLContext> {
        val dataSourceConfig: DataSourceConfig = get()
        val dataSource: HikariDataSource = get()
        DataSourceConfig.flywayMigrate(dataSource, dataSourceConfig)
        DataSourceConfig.createDSLContext(dataSource, dataSourceConfig)
    }

    //Utils
    single<PropertyConfigUtils> { PropertyConfigUtils() }
    single<ApplicationEnvironment> { get<ApplicationEnvironment>() }

    //Repository for DI
    single<AppUserRepository> { AppUserRepository(get()) }
    single<AvailableEquipmentRepository> { AvailableEquipmentRepository(get()) }
    single<EquipmentRepository> { EquipmentRepository(get()) }
    single<EquipmentTypeRepository> { EquipmentTypeRepository(get()) }
    single<FactoryRepository> { FactoryRepository(get()) }
    single<RoleRepository> { RoleRepository(get()) }

    //Service for DI
    single<AppUserService> { AppUserService(get()) }
    single<AvailableEquipmentService> { AvailableEquipmentService(get(), get()) }
    single<EquipmentService> { EquipmentService(get()) }
    single<EquipmentTypeService> { EquipmentTypeService(get()) }
    single<FactoryService> { FactoryService(get()) }
    single<RoleService> { RoleService(get()) }

    //Kafka
    single<KafkaConsumer> { KafkaConsumer(get(), get())  }
}

