package repositorio

import entidades.Alimento
import entidades.Exercicio

class ExerciciosCadastrados {

    companion  object{
        private var exercicios: MutableList<Exercicio> = arrayListOf()

        fun adicionarExercicio(exercicio: Exercicio){
            exercicios.add(exercicio)
        }

        fun removerExercicios(nome: String){
            exercicios.removeIf{it.getNome()==nome}
        }

        fun getExercicios(): MutableList<Exercicio>{
            return exercicios
        }
    }
}