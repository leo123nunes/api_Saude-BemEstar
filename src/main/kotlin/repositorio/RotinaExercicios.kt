package repositorio

import entidades.Exercicio

class RotinaExercicios {
    private var exercicios: MutableList<Exercicio> = mutableListOf()

    fun adicionarExercicio(exercicio: Exercicio){
        exercicios.add(exercicio)
    }

    fun removerAlimento(nome: String){
        exercicios.removeIf{it.getNome()==nome}
    }

    fun getExercicios(): MutableList<Exercicio>{
        return exercicios
    }
}