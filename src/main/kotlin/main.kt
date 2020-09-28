import entidades.Usuario
import enums.IMC
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
import objetivos.UsuarioFitness
import objetivos.UsuarioHipertrofico
import repositorio.Alimentos
import repositorio.Usuarios

var usuarios: Usuarios = Usuarios()

var ALIMENTOS: Alimentos = Alimentos()

fun main() {

    embeddedServer(Netty, 8080) {
        routing {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }

            get("/usuarios") {
                if (usuarios.getUsuariosImcAll().isEmpty()) {
                    call.respondText { "<h1>Nenhum usuario esta cadastrado no sistema.</h1>" }
                } else {
                    call.respond(usuarios.getUsuariosImcAll())
                }
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
            get("/usuarios/hipertroficos") {
                call.respond(usuarios.getUsuariosImcAll().filter { it is UsuarioHipertrofico })
            }

            get("/usuarios/fitness") {
                call.respond(usuarios.getUsuariosImcAll().filter { it is UsuarioFitness })

            }


            post("/usuarios") {
                val novoUsuario = call.receive<Usuario>()
                if (novoUsuario.grauIMC() == IMC.ABAIXO ||
                        novoUsuario.grauIMC() == IMC.NORMAL) {
                    val novoUsuarioHipertrofico = UsuarioHipertrofico(novoUsuario.getNome(),
                            novoUsuario.getIdade(), novoUsuario.getPeso(), novoUsuario.getAltura(),
                            novoUsuario.getCpf())
                    usuarios.adicionarUsuario(novoUsuarioHipertrofico)
                } else {
                    val novoUsuarioFitness = UsuarioHipertrofico(novoUsuario.getNome(),
                            novoUsuario.getIdade(), novoUsuario.getPeso(), novoUsuario.getAltura(),
                            novoUsuario.getCpf())
                    usuarios.adicionarUsuario(novoUsuarioFitness)
                }
            }
        }
    }.start(wait = true)
}
