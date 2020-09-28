package objetivos

import entidades.Alimento
import entidades.Exercicio
import entidades.Usuario
import enums.Cores
import enums.MusculosCorpo
import enums.Vitaminas

class UsuarioHipertrofico(nome: String, idade: Int, peso: Double,
                          altura: Double, cpf: String) : Usuario(nome,idade,peso,altura,cpf){

    override fun montarDieta(){
        limparDieta()
        var vitaminasCarne = listOf(Vitaminas.B1,Vitaminas.B2,Vitaminas.B3,Vitaminas.PROTEINA,Vitaminas.GORDURA)
        adicionarAlimento(Alimento("Carne", Cores.VERMELHO, 143.0, vitaminasCarne))

        var vitaminasFrango = listOf(Vitaminas.B3,Vitaminas.FERRO,Vitaminas.PROTEINA)
        adicionarAlimento(Alimento("Frango", Cores.ROSA, 239.0, vitaminasFrango))

        var vitaminasOvo = listOf(Vitaminas.B2,Vitaminas.B6,Vitaminas.B12,Vitaminas.PROTEINA,Vitaminas.E)
        adicionarAlimento(Alimento("Ovo", Cores.BRANCO, 52.0, vitaminasOvo))

        var vitaminasAtum = listOf(Vitaminas.PROTEINA,Vitaminas.POTASSIO,Vitaminas.MAGNESIO)
        adicionarAlimento(Alimento("Atum", Cores.VERMELHO, 130.0, vitaminasAtum))
    }

    override fun montarExercicios(){
        var musculosSupino = listOf(MusculosCorpo.TRICEPS, MusculosCorpo.PEITO)
        adicionarExercicio(Exercicio("Supino",musculosSupino))

        var musculosAbdominal = listOf(MusculosCorpo.ABDOMEN)
        adicionarExercicio(Exercicio("Abdominal",musculosAbdominal))

        var musculosLegPress = listOf(MusculosCorpo.PERNA, MusculosCorpo.PANTURRILHA)
        adicionarExercicio(Exercicio("LegPress",musculosLegPress))

        var musculosRoscaDireta = listOf(MusculosCorpo.BICEPS, MusculosCorpo.ANTEBRACO)
        adicionarExercicio(Exercicio("Rosca Direta",musculosRoscaDireta))

        var musculosTricepsFrances = listOf(MusculosCorpo.TRICEPS)
        adicionarExercicio(Exercicio("Triceps Frances",musculosTricepsFrances))
    }
}