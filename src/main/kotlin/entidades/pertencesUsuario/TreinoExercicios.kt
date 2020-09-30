package entidades.pertencesUsuario

import entidades.Exercicio
import repositorio.companionObjects.ExerciciosCadastrados

// Esta classe representa o treino através de uma lista de exercícios
// de cada usuário

class TreinoExercicios {
    private var exercicios: MutableList<Exercicio> = mutableListOf()
    private var totalCaloriasQueimadas = 0.0

    fun adicionarExercicio(exercicio: Exercicio) {
        exercicios.add(exercicio)
        totalCaloriasQueimadas += exercicio.getCaloriasQueimadas()
    }

    fun getTotalCaloriasQueimadas(): Double {
        return totalCaloriasQueimadas
    }

    fun removerExercicio(nome: String) {
        var exercicio = ExerciciosCadastrados.getExercicio(nome)
        exercicios.removeIf { it.getNome() == nome }

        totalCaloriasQueimadas -= exercicio!!.getCaloriasQueimadas()
    }

    fun limparExercicios() {
        exercicios.clear()
    }

    fun getExercicios(): MutableList<Exercicio> {
        return exercicios
    }
}