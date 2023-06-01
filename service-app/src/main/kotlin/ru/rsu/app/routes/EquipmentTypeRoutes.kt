package ru.rsu.app.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.koin.ktor.ext.inject
import ru.rsu.app.dto.EquipmentTypeDto
import ru.rsu.app.dto.response.StandardResponseDto
import ru.rsu.app.services.EquipmentTypeService

fun Route.equipmentTypeRouting() {
    val equipmentTypeService by inject<EquipmentTypeService>()

    route("/equipmentType") {
        get {
            val result = equipmentTypeService.findListAllEquipmentType()
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result)
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        get("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val result = equipmentTypeService.findEquipmentTypeById(id)
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result.first())
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        post {
            val equipmentType = call.receive<EquipmentTypeDto>()
            equipmentTypeService.addEquipmentType(equipmentType)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        patch("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val equipmentType = call.receive<EquipmentTypeDto>()
            equipmentTypeService.updateEquipmentType(equipmentType, id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        delete("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            equipmentTypeService.deleteEquipmentType(id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
    }
}