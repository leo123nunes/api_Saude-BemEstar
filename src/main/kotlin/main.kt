import Entidades.Pessoa
import com.sun.xml.internal.ws.client.ContentNegotiation
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {

    embeddedServer(Netty,8080){
        routing{
            var mateus = Pessoa("Matheus",20,150.5, 1.75)
            mateus.calcularIMC()

            get("/"){
                call.respondText("<h1> ${mateus.calcularIMC()} </h1>", ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}
