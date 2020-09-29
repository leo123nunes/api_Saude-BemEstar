package entidades

import enums.MusculosCorpo

// Esta classe representa cada exercício do treino do usuário

data class Exercicio(
    private val nome: String,
    private var musculos: List<MusculosCorpo>,
    private var caloriasQueimadas: Double,
    private var tempoMinutos: Int
) {
    fun getNome(): String {
        return nome
    }

    fun getTempoDuracao(): Int {
        return tempoMinutos
    }

    fun getCaloriasQueimadas(): Double {
        return caloriasQueimadas
    }

    fun getMusculos(): List<MusculosCorpo> {
        return musculos
    }

}