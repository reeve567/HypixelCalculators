package dev.reeve.plugins

import dev.reeve.pages.PageBuilder
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

	routing {
		get("/") {
			call.respondText(
				PageBuilder().build().textContent
			)
		}
	}
}
