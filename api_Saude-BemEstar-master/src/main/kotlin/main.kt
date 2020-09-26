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
            var mateus = Pessoa("Matheus",20,150.5, 1.75, 1.0)
            mateus.calcularIMC()

            get("/"){
                call.respondText("<h1> ${mateus.calcularIMC()} </h1>", ContentType.Text.Html)
            }

            val get = get("/pietro") {
                call.respondText { "${mateus.Necesidade()}" }
            }
        }
    }.start(wait = true)
}
