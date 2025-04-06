import io.ktor.server.engine.*
import io.ktor.http.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(io.ktor.server.plugins.cors.routing.CORS) {
            anyHost()
        }
        
        routing {
            get("/api/hello") {
                call.respondText("Hello from Kotlin - Docker!", ContentType.Text.Plain)
            }
        }
    }.start(wait = true)
}
