package entidades

import enums.Vitaminas

// Esta classe representa cada alimento da dieta do usuário.

data class Alimento(
    private val nome: String,
    private val calorias: Double, private val vitaminas: List<Vitaminas>
) {

    fun getNome(): String {
        return nome
    }

    fun getCalorias(): Double {
        return calorias
    }

    fun getVitaminas(): List<Vitaminas> {
        return vitaminas
    }
}