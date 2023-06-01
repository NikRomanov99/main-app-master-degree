package ru.rsu.app.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.koin.ktor.ext.inject
import ru.rsu.app.dto.FactoryDto
import ru.rsu.app.dto.response.StandardResponseDto
import ru.rsu.app.services.FactoryService

fun Route.factoryRouting() {
    val factoryService by inject<FactoryService>()

    route("/factory") {
        get {
            val result = factoryService.findListAllFactory()
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result)
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        get("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val result = factoryService.findFactoryById(id)
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result.first())
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        post {
            val factory = call.receive<FactoryDto>()
            factoryService.addFactory(factory)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        patch("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val factory = call.receive<FactoryDto>()
            factoryService.updateFactory(factory, id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        delete("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            factoryService.deleteFactory(id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
    }
}