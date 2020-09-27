package repositorio

import entidades.Alimentos
import entidades.Exercicios

class RotinaExercicios {
    private lateinit var exercicios: MutableList<Exercicios>

    fun adicionarExercicio(exercicio: Exercicios){
        exercicios.add(exercicio)
    }

    fun removerAlimento(nome: String){
        exercicios.removeIf{it.nome==nome}
    }

    fun getExercicios(): MutableList<Exercicios>{
        return exercicios
    }
}