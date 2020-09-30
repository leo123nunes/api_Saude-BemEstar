package servidor

import entidades.Alimento
import entidades.Exercicio
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
import repositorio.companionObjects.AlimentosCadastrados
import repositorio.companionObjects.ExerciciosCadastrados
import repositorio.UsuariosCadastrados

//Servidor main da aplicação

var usuariosCadastrados: UsuariosCadastrados = UsuariosCadastrados()

fun main() {

    AlimentosCadastrados.inserirAlimentos()
    ExerciciosCadastrados.inserirExercicios()

    embeddedServer(Netty, 8080) {
        routing {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }

            get("/usuarios") {
                if (usuariosCadastrados.getUsuarios().isEmpty()) {
                    call.respondText { "<h1>Nenhum usuario esta cadastrado no sistema.</h1>" }
                } else {
                    call.respond(usuariosCadastrados.getUsuarios())
                }
            }

            get("/alimentos") {
                if (AlimentosCadastrados.getAlimentos().size == 0) {
                    call.respondText { "<h1>Nenhum alimento esta cadastrado no sistema.</h1>" }
                } else {
                    call.respond(AlimentosCadastrados.getAlimentos())
                }
            }

            get("/exercicios") {
                if (ExerciciosCadastrados.getExercicios().size == 0) {
                    call.respondText { "<h1>Nenhum exercicio esta cadastrado no sistema.</h1>" }
                } else {
                    call.respond(ExerciciosCadastrados.getExercicios())
                }
            }

            get("/usuarios/imc/abaixo") {
                call.respond(usuariosCadastrados.getUsuariosImcAbaixo())
            }

            get("/usuarios/imc/normal") {
                call.respond(usuariosCadastrados.getUsuariosImcNormal())
            }

            get("/usuarios/imc/sobrepeso") {
                call.respond(usuariosCadastrados.getUsuariosImcSobrepeso())
            }

            get("/usuarios/imc/obesidade1") {
                call.respond(usuariosCadastrados.getUsuariosImcObesidade1())
            }

            get("/usuarios/imc/obesidade2") {
                call.respond(usuariosCadastrados.getUsuariosImcObesidade2())
            }

            get("/usuarios/imc/obesidade3") {
                call.respond(usuariosCadastrados.getUsuariosImcObesidade3())
            }

            get("/usuarios/hipertroficos") {
                call.respond(usuariosCadastrados.getUsuarios().filter { it is UsuarioHipertrofico })
            }

            get("/usuarios/fitness") {
                call.respond(usuariosCadastrados.getUsuarios().filter { it is UsuarioFitness })

            }

            get("/usuarios/imc") {
                call.respond(usuariosCadastrados.getUsuarios())

            }

            post("/usuarios") {
                val novoUsuario = call.receive<Usuario>()
                if (novoUsuario.grauIMC() == IMC.ABAIXO ||
                    novoUsuario.grauIMC() == IMC.NORMAL
                ) {
                    val novoUsuarioHipertrofico = UsuarioHipertrofico(
                        novoUsuario.getNome(),
                        novoUsuario.getIdade(), novoUsuario.getPeso(), novoUsuario.getAltura(),
                        novoUsuario.getCpf(), novoUsuario.getFator()
                    )
                    usuariosCadastrados.adicionarUsuario(novoUsuarioHipertrofico)
                } else {
                    val novoUsuarioFitness = UsuarioHipertrofico(
                        novoUsuario.getNome(),
                        novoUsuario.getIdade(), novoUsuario.getPeso(), novoUsuario.getAltura(),
                        novoUsuario.getCpf(), novoUsuario.getFator()
                    )
                    usuariosCadastrados.adicionarUsuario(novoUsuarioFitness)
                }
                call.respond("Usuário inserido com sucesso!")
            }

            post("/exercicios") {
                val novoExercicio = call.receive<Exercicio>()
                ExerciciosCadastrados.adicionarExercicio(novoExercicio)
                call.respond("Exercicio inserido com sucesso!")
            }

            post("/alimentos") {
                val novoAlimento = call.receive<Alimento>()
                AlimentosCadastrados.adicionarAlimento(novoAlimento)
                call.respond("Alimento inserido com sucesso!")
            }

        }
    }.start(wait = true)
}
