package repositorio

import entidades.Alimento
import enums.Cores
import enums.Vitaminas

class RotinaAlimentos {
    private var alimentos: MutableList<Alimento> = mutableListOf()

     fun adicionarAlimento(alimento: Alimento){
         alimentos.add(alimento)
     }

    fun limparAlimentos(){
        alimentos.clear()
    }

    fun removerAlimento(nome: String){
        alimentos.removeIf{it.getNome()==nome}
    }

    fun getAlimentos(): MutableList<Alimento>{
        return alimentos
    }
}