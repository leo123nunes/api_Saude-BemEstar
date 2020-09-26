package Entidades

class Pessoa(var nome: String, var idade: Int,var peso: Double,var altura: Double, var fator: Double) {

    fun calcularIMC(): String{
        var imc = peso / (altura*altura)
        return "Seu imc é igual a ${"%.2f".format(imc).replace(",",".")}, sua situação está em ${verificaPeso(imc)}."
    }

    fun verificaPeso(imc: Double): String{
        return when{
            imc < 18.5 -> "Abaixo do peso"
            imc > 18.5 && imc < 24.9 -> "Peso normal"
            imc > 25 && imc < 29.9 -> "Sobrepeso"
            imc > 30 && imc < 34.9 -> "Obesidade grau 1"
            imc > 35 && imc < 39.9 -> "Obesidade grau 2"
            else -> "Obesidade grau 3"
        }
    }

    fun Necesidade(): String{
            var energia:Double = 135.3 -  (30.8 * idade) + fator * (10 * peso + 934 * altura ) + 25
            return "Sua Necessidade Energetica é de ${"%.0f".format(energia).replace(",",".")} Kcal"
    }
}