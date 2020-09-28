package repositorio

import entidades.Alimento
import enums.Cores
import enums.Vitaminas

class Alimentos {
    private var alimentos: MutableList<Alimento> = mutableListOf()
    private var dietaFitnesses: List<Alimento> = mutableListOf()
    private var dietaHipertrofica: List<Alimento> = mutableListOf()

     fun adicionarAlimento(alimento: Alimento){
         alimentos.add(alimento)
     }

    fun limparAlimentos(){
        alimentos.clear()
    }

    fun removerAlimento(nome: String){
        alimentos.removeIf{it.nome==nome}
    }

    fun getAlimentos(): MutableList<Alimento>{
        return alimentos
    }
}