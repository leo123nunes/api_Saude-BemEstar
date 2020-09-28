package objetivos

import entidades.Alimento
import entidades.Exercicio
import entidades.Usuario
import enums.Cores
import enums.PartesCorpo
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
        var musculosSupino = listOf(PartesCorpo.TRICEPS, PartesCorpo.PEITO)
        adicionarExercicio(Exercicio("Supino",musculosSupino))

        var musculosAbdominal = listOf(PartesCorpo.ABDOMEN)
        adicionarExercicio(Exercicio("Abdominal",musculosAbdominal))

        var musculosLegPress = listOf(PartesCorpo.PERNA, PartesCorpo.PANTURRILHA)
        adicionarExercicio(Exercicio("LegPress",musculosLegPress))

        var musculosRoscaDireta = listOf(PartesCorpo.BICEPS, PartesCorpo.ANTEBRACO)
        adicionarExercicio(Exercicio("Rosca Direta",musculosRoscaDireta))

        var musculosTricepsFrances = listOf(PartesCorpo.TRICEPS)
        adicionarExercicio(Exercicio("Triceps Frances",musculosTricepsFrances))
    }
}