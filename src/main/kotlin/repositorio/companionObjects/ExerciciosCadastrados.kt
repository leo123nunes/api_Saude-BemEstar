package repositorio.companionObjects

import entidades.Exercicio
import enums.MusculosCorpo

// Esta classe representa os exercícios cadastrados no sistema através
// de uma lista de Exercicio.

class ExerciciosCadastrados {

    companion object {
        private var exercicios: MutableList<Exercicio> = arrayListOf()

        fun adicionarExercicio(exercicio: Exercicio) {
            if(exercicios.filter{it.getNome()==exercicio.getNome()}.isEmpty()){
                exercicios.add(exercicio)
            }
        }

        fun getExercicio(nome: String): Exercicio?{
            for( x in exercicios){
                if (x.getNome() == nome){
                    return x
                }
            }
            return null
        }

        fun removerExercicios(nome: String) {
            exercicios.removeIf { it.getNome() == nome }
        }

        fun getExercicios(): MutableList<Exercicio> {
            return exercicios
        }

        fun inserirExercicios(){
            var musculosSupino = listOf(MusculosCorpo.TRICEPS, MusculosCorpo.PEITO)
            adicionarExercicio(Exercicio("Supino", musculosSupino, 60.0))

            var musculosAbdominal = listOf(MusculosCorpo.ABDOMEN)
            adicionarExercicio(Exercicio("Abdominal", musculosAbdominal, 120.0))

            var musculosLegPress = listOf(MusculosCorpo.PERNA, MusculosCorpo.PANTURRILHA)
            adicionarExercicio(Exercicio("LegPress", musculosLegPress, 80.0))

            var musculosRoscaDireta = listOf(MusculosCorpo.BICEPS, MusculosCorpo.ANTEBRACO)
            adicionarExercicio(Exercicio("Rosca Direta", musculosRoscaDireta, 40.0))

            var musculosTricepsFrances = listOf(MusculosCorpo.TRICEPS)
            adicionarExercicio(Exercicio("Triceps Frances", musculosTricepsFrances, 80.0))

            var musculosBicicleta = listOf(MusculosCorpo.ABDOMEN, MusculosCorpo.PANTURRILHA, MusculosCorpo.PERNA)
            adicionarExercicio(Exercicio("Bicicleta", musculosBicicleta, 120.0))

            var musculosCorrida = listOf(MusculosCorpo.PERNA)
            adicionarExercicio(Exercicio("Corrida", musculosCorrida, 109.0))

            var musculosTreinoHit = listOf(MusculosCorpo.PERNA, MusculosCorpo.PANTURRILHA, MusculosCorpo.ABDOMEN)
            adicionarExercicio(Exercicio("Treino Hit", musculosTreinoHit, 300.0))
        }
    }
}