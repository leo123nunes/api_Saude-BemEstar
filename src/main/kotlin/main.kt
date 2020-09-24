import Pessoa.Pessoa
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
            get("/"){
                call.respondText("<h1> Testando </h1>", ContentType.Text.Html)
            }
        }
    }.start(wait = true)

    var Mateus = Pessoa()

    Mateus.nome = "Matheus"
    Mateus.altura = 1.75
    Mateus.peso = 150.5

    imc(Mateus.peso, Mateus.altura)
}

fun imc(peso: Double, altura: Double) {
    var imc: Double = peso / (altura * altura)
    println("O imc da pessoa é $imc")
    when {
        imc < 18.5 -> println("Você está abaixo do peso ideal.")
        imc >= 18.5 && imc < 25 -> println("Você está no peso ideal.")
        imc >= 25 && imc < 30 -> println("Você está em pré-obesidade.")
        imc >= 30 && imc < 35 -> println("Você está em besidade de grau 1.")
        imc >= 35 && imc < 40 -> println("Você está em besidade de grau 2.")
        else -> println("Você está em besidade mórbida.")
    }
}
