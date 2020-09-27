package repositorio

import entidades.Alimentos
import entidades.Exercicios

class RotinaAlimentos {
    private lateinit var dieta: MutableList<Alimentos>

     fun adicionarAlimento(alimento: Alimentos){
         dieta.add(alimento)
     }

    //funcao para remover os alimentos da dieta pelo nome
    fun removerAlimento(nome: String){
        dieta.removeIf{it.nome==nome}
    }

    fun getDieta(): MutableList<Alimentos>{
        return dieta
    }
}