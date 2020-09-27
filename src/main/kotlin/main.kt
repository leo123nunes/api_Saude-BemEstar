import com.google.gson.internal.`$Gson$Types`
import entidades.Usuarios
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.put
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import repositorio.UsuariosCadastrados

val usuarios: UsuariosCadastrados = UsuariosCadastrados()

fun main() {

    embeddedServer(Netty,8080){
        routing{
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }

            get("/usuarios") {
                if(usuarios.getUsuariosImcAll().isEmpty()){
                    call.respondText{"<h1>Nenhum usuario esta cadastrado no sistema.</h1>"}
                }
                call.respond(usuarios.getUsuariosImcAll())
            }

            get("/usuarios/imc/abaixo") {
                call.respond(usuarios.getUsuariosImcAbaixo())
            }

            get("/usuarios/imc/normal") {
                call.respond(usuarios.getUsuariosImcNormal())
            }

            get("/usuarios/imc/sobrepeso") {
                call.respond(usuarios.getUsuariosImcSobrepeso())
            }

            get("/usuarios/imc/obesidade1") {
                call.respond(usuarios.getUsuariosImcObesidade1())
            }

            get("/usuarios/imc/obesidade2") {
                call.respond(usuarios.getUsuariosImcObesidade2())
            }

            get("/usuarios/imc/obesidade3") {
                call.respond(usuarios.getUsuariosImcObesidade3())
            }

            post("/usuarios") {
                val novoUsuario = call.receive<Usuarios>()
                usuarios.adicionarUsuario(novoUsuario)
            }

        }
    }.start(wait = true)
}
