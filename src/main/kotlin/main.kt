import entidades.Usuario
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.gson.*
import io.ktor.request.*
import io.ktor.response.*
import repositorio.Alimentos
import repositorio.Usuarios

val USUARIOS: Usuarios = Usuarios()

val ALIMENTOS: Alimentos = Alimentos()

fun main() {

    embeddedServer(Netty,8080){
        routing{
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }

            get("/usuarios") {
                if(USUARIOS.getUsuariosImcAll().isEmpty()){
                    call.respondText{"<h1>Nenhum usuario esta cadastrado no sistema.</h1>"}
                }
                call.respond(USUARIOS.getUsuariosImcAll())
            }

            get("/usuarios/imc/abaixo") {
                call.respond(USUARIOS.getUsuariosImcAbaixo())
            }

            get("/usuarios/imc/normal") {
                call.respond(USUARIOS.getUsuariosImcNormal())
            }

            get("/usuarios/imc/sobrepeso") {
                call.respond(USUARIOS.getUsuariosImcSobrepeso())
            }

            get("/usuarios/imc/obesidade1") {
                call.respond(USUARIOS.getUsuariosImcObesidade1())
            }

            get("/usuarios/imc/obesidade2") {
                call.respond(USUARIOS.getUsuariosImcObesidade2())
            }

            get("/usuarios/imc/obesidade3") {
                call.respond(USUARIOS.getUsuariosImcObesidade3())
            }

            post("/usuarios") {
                val novoUsuario = call.receive<Usuario>()
                USUARIOS.adicionarUsuario(novoUsuario)
            }

        }
    }.start(wait = true)
}
