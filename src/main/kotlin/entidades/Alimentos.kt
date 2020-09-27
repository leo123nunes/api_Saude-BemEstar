package entidades

import enums.CoresAlimentos
import enums.VitaminasAlimentos

data class Alimentos(val nome: String, val cor: CoresAlimentos,
                     val calorias: Double, val vitaminas: List<VitaminasAlimentos>){
}