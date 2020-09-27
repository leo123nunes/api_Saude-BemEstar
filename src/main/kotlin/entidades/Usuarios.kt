package entidades

import enums.IMCGrau

class Usuarios(var nome: String, var idade: Int, var peso: Double,
               var altura: Double, private var cpf: String) {

    private lateinit var exercicios: List<Exercicios>
    private lateinit var grauIMC: IMCGrau

    fun getCpf(): String{
        return cpf
    }

    fun calcularIMC(): Double{
        return peso / (altura*altura)
    }

    fun verificaPeso(): IMCGrau{
        var imc = calcularIMC()
        return when{
            imc < 18.5 -> IMCGrau.ABAIXO
            imc > 18.5 && imc < 24.9 -> IMCGrau.NORMAL
            imc > 25 && imc < 29.9 -> IMCGrau.SOBREPESO
            imc > 30 && imc < 34.9 -> IMCGrau.OBESIDADE1
            imc > 35 && imc < 39.9 -> IMCGrau.OBESIDADE2
            else -> IMCGrau.OBESIDADE3
        }
    }
}