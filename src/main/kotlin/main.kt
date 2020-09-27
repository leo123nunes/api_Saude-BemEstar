import entidades.Usuarios
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.put
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {

    embeddedServer(Netty,8080){
        routing{
            var usuarios: Usuarios ?= null

            get("/"){
                call.respondText ("$usuarios" )
            }
        }
    }.start(wait = true)
}
