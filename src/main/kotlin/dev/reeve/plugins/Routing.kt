package dev.reeve.plugins

import dev.reeve.pages.Header
import dev.reeve.pages.NavigationBar
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
				PageBuilder()
					.addComponent(NavigationBar())
					.addComponent(Header("Home"))
					.build()
					.textContent
			)
		}
	}
}
