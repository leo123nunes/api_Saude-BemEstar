package repositorio

import entidades.Exercicio

// Esta classe representa o treino através de uma lista de exercícios
// de cada usuário

class RotinaExercicios {
    private var exercicios: MutableList<Exercicio> = mutableListOf()

    fun adicionarExercicio(exercicio: Exercicio){
        exercicios.add(exercicio)
    }

    fun removerExercicio(nome: String){
        exercicios.removeIf{it.getNome()==nome}
    }

    fun getExercicios(): MutableList<Exercicio>{
        return exercicios
    }
}