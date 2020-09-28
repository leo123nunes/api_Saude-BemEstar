package repositorio

import entidades.Exercicio

class Exercicios {
    private lateinit var exercicios: MutableList<Exercicio>

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