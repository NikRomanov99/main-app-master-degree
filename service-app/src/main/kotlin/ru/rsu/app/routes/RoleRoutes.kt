package ru.rsu.app.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.koin.ktor.ext.inject
import ru.rsu.app.dto.RoleDto
import ru.rsu.app.dto.response.StandardResponseDto
import ru.rsu.app.services.RoleService

fun Route.roleRouting() {
    val roleService by inject<RoleService>()

    route("/role") {
        get {
            val result = roleService.findListAllRole()
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result)
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        get("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val result = roleService.findRoleById(id)
            if (result.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, result.first())
            } else {
                call.respond(HttpStatusCode.NotFound, StandardResponseDto(false, HttpStatusCode.NotFound.value))
            }
        }
        post {
            val role = call.receive<RoleDto>()
            roleService.addRole(role)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        patch("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            val role = call.receive<RoleDto>()
            roleService.updateRole(role, id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
        delete("/{id?}") {
            val id = call.parameters.getOrFail("id").toLong()
            roleService.deleteRole(id)
            call.respond(HttpStatusCode.OK, StandardResponseDto(true, HttpStatusCode.OK.value))
        }
    }
}