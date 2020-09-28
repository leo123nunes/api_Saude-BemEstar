package entidades

import enums.MusculosCorpo

data class Exercicio (private var nome: String,
                        private var musculos: List<MusculosCorpo>){
    fun getNome(): String{
        return nome
    }

    fun getMusculos(): List<MusculosCorpo> {
        return musculos
    }

}