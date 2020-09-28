package entidades

import enums.Cores
import enums.Vitaminas

data class Alimento(val nome: String, val cor: Cores,
                    val calorias: Double, val vitaminas: List<Vitaminas>){
}