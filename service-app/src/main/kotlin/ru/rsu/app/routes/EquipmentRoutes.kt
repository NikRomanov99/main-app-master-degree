package ru.rsu.app.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.koin.ktor.ext.inject
import ru.rsu.app.dto.EquipmentDto
import ru.rsu.app.dto.response.StandardResponseDto
import ru.rsu.app.services.EquipmentService

fun Route.equipmentRouting() {
    val equipmentService by inject<EquipmentService>()

    route("/equipment") {
        get {
            val result = equipmentService.findListAllEquipment()
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result)
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        get("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val result = equipmentService.findEquipmentById(id)
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result.first())
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        post {
            val equipment = call.receive<EquipmentDto>()
            equipmentService.addEquipment(equipment)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        patch("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val equipment = call.receive<EquipmentDto>()
            equipmentService.updateEquipment(equipment, id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        delete("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            equipmentService.deleteEquipment(id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
    }
}