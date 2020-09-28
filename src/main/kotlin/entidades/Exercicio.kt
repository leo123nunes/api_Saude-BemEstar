package entidades

import enums.MusculosCorpo

// Esta classe representa cada exercício do treino do usuário

data class Exercicio (private var nome: String,
                        private var musculos: List<MusculosCorpo>){
    fun getNome(): String{
        return nome
    }

    fun getMusculos(): List<MusculosCorpo> {
        return musculos
    }

}