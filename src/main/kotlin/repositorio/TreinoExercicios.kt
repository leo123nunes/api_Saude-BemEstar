package repositorio

import entidades.Exercicio

// Esta classe representa o treino através de uma lista de exercícios
// de cada usuário

class TreinoExercicios {
    private var exercicios: MutableList<Exercicio> = mutableListOf()
    private var totalCaloriasQueimadas = 0.0

    fun adicionarExercicio(exercicio: Exercicio){
        exercicios.add(exercicio)
        totalCaloriasQueimadas += exercicio.getCaloriasQueimadas()
    }

    fun getTotalCaloriasQueimadas(): Double{
        return totalCaloriasQueimadas
    }

    fun removerExercicio(nome: String){
        exercicios.removeIf{it.getNome()==nome}
    }

    fun limparExercicios() {
        exercicios.clear()
    }

    fun getExercicios(): MutableList<Exercicio>{
        return exercicios
    }
}