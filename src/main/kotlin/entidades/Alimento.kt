package entidades

import enums.Cores
import enums.Vitaminas

// Esta classe representa cada alimento da dieta do usuário.

data class Alimento(private var nome: String, private var cor: Cores,
                    private var calorias: Double, private var vitaminas: List<Vitaminas>){

    fun getNome(): String{
        return nome
    }

    fun getCor(): Cores{
        return cor
    }

    fun getCalorias(): Double{
        return calorias
    }

    fun getVitaminas(): List<Vitaminas>{
        return vitaminas
    }
}