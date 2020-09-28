package repositorio

import entidades.Exercicio

class Exercicios {
    private var exercicios: MutableList<Exercicio> = mutableListOf()

    fun adicionarExercicio(exercicio: Exercicio){
        exercicios.add(exercicio)
    }

    fun removerAlimento(nome: String){
        exercicios.removeIf{it.nome==nome}
    }

    fun getExercicios(): MutableList<Exercicio>{
        return exercicios
    }
}