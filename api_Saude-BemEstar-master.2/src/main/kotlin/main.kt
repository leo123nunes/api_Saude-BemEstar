import Entidades.Pessoa
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.http.ContentType
import io.ktor.response.*
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {

    embeddedServer(Netty,8080){
        routing{

            get("/"){
                call.respondText(
                        "<h1> ${Pessoa()} </h1>",
                        ContentType.Text.Html
                )
            }
            get("/pietro"){

            }
        }
    }.start(wait = true)
}