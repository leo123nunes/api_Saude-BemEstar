import Pessoa.Pessoa

fun main() {
    var Mateus = Pessoa()

    Mateus.nome = "Matheus"
    Mateus.altura = 1.75
    Mateus.peso = 74.5
    Mateus.fator = 1.50

    imc(Mateus.peso, Mateus.altura)
    necessidade(Mateus.idade, Mateus.peso, Mateus.altura, Mateus.fator)
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

fun necessidade(idade: Int, peso: Double, altura: Double, fator: Double) {
    var energia: Double = 135.3 - (30.8 * idade) + fator * (10 * peso + 934 * altura) + 25
    println("Sua Necessidade Energetica é de $energia Kcal")
}
