package ru.rsu.app.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.koin.ktor.ext.inject
import ru.rsu.app.dto.AvailableEquipmentDto
import ru.rsu.app.dto.response.StandardResponseDto
import ru.rsu.app.services.AvailableEquipmentService

fun Route.availableEquipmentRepository() {
    val availableEquipmentService by inject<AvailableEquipmentService>()

    route("/availableEquipment") {
        get {
            val result = availableEquipmentService.findListAllAvailableEquipment()
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result)
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        get("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val result = availableEquipmentService.findAvailableEquipmentById(id)
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result.first())
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        post {
            val availableEquipment = call.receive<AvailableEquipmentDto>()
            availableEquipmentService.addAvailableEquipment(availableEquipment)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        patch("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val availableEquipment = call.receive<AvailableEquipmentDto>()
            availableEquipmentService.updateAvailableEquipment(availableEquipment, id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        delete("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            availableEquipmentService.deleteAvailableEquipment(id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
    }
}