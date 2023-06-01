package ru.rsu.app.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import ru.rsu.app.routes.*

fun Application.configureRouting() {
    routing {
        equipmentTypeRouting()
        factoryRouting()
        roleRouting()
        appUserRouting()
        equipmentRouting()
        availableEquipmentRepository()
    }
}