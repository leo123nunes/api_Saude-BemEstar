package entidades

import enums.GrauIMC

class Usuarios(var nome: String, var idade: Int, var peso: Double,
               var altura: Double, private var cpf: String) {

    private lateinit var exercicios: List<Exercicios>
    private lateinit var grauIMC: GrauIMC

    fun getCpf(): String{
        return cpf
    }

    fun calcularIMC(): Double{
        return peso / (altura*altura)
    }

    fun verificaPeso(): GrauIMC{
        var imc = calcularIMC()
        return when{
            imc < 18.5 -> GrauIMC.ABAIXO
            imc > 18.5 && imc < 24.9 -> GrauIMC.NORMAL
            imc > 25 && imc < 29.9 -> GrauIMC.SOBREPESO
            imc > 30 && imc < 34.9 -> GrauIMC.OBESIDADE1
            imc > 35 && imc < 39.9 -> GrauIMC.OBESIDADE2
            else -> GrauIMC.OBESIDADE3
        }
    }
}