package Entidades

class Pessoa(var nome: String, var idade: Int,var peso: Double,var altura: Double) {

    fun calcularIMC(): String{
        var imc = peso / (altura*altura)
        return "Seu imc é igual a ${"%.2f".format(imc).replace(",",".")}, sua situação está em ${verificaPeso(imc)}."
    }

    fun verificaPeso(imc: Double): String{
        return when{
            imc < 18.5 -> "Abaixo do peso"
            imc >= 18.5 && imc < 24.9 -> "Peso normal"
            imc >= 25 && imc < 29.9 -> "Sobrepeso"
            imc >= 30 && imc < 34.9 -> "Obesidade grau 1"
            imc >= 35 && imc < 39.9 -> "Obesidade grau 2"
            else -> "Obesidade grau 3"
        }
    }
}
