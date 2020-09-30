package entidades

import enums.MusculosCorpo

// Esta classe representa cada exercício do treino do usuário

data class Exercicio(
    private val nome: String,
    private var musculos: List<MusculosCorpo>,
    private var caloriasQueimadas: Double
) {
    fun getNome(): String {
        return nome
    }

    fun getCaloriasQueimadas(): Double {
        return caloriasQueimadas
    }

    fun getMusculos(): List<MusculosCorpo> {
        return musculos
    }

}