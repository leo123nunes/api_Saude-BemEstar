package objetivos

import entidades.Alimento
import entidades.Exercicio
import entidades.Usuario
import enums.Cores
import enums.MusculosCorpo
import enums.TiposObjetivos
import enums.Vitaminas
import repositorio.companionObjects.AlimentosCadastrados
import repositorio.companionObjects.ExerciciosCadastrados

// Esta classe monta um usuário que possui objetivo hipertrofico de acordo
// com a sua gordura corporal, herdeira da classe Usuario

class UsuarioHipertrofico(nome: String, idade: Int, peso: Double,
                          altura: Double, cpf: String, fator: Double) : Usuario(nome,idade,peso,altura,cpf,fator){

    private val tipoObjetivo = TiposObjetivos.HIPERTROFIA

    override fun montarDieta(){
        limparDieta()
        var vitaminasCarne = listOf(Vitaminas.B1,Vitaminas.B2,Vitaminas.B3,Vitaminas.PROTEINA,Vitaminas.GORDURA)
        AlimentosCadastrados.adicionarAlimento(Alimento("Arroz", Cores.BRANCO, 130.0, vitaminasCarne))
        adicionarAlimento(Alimento("Carne", Cores.VERMELHO, 143.0, vitaminasCarne))

        var vitaminasFrango = listOf(Vitaminas.B3,Vitaminas.FERRO,Vitaminas.PROTEINA)
        AlimentosCadastrados.adicionarAlimento(Alimento("Frango", Cores.ROSA, 239.0, vitaminasFrango))
        adicionarAlimento(Alimento("Frango", Cores.ROSA, 239.0, vitaminasFrango))

        var vitaminasOvo = listOf(Vitaminas.B2,Vitaminas.B6,Vitaminas.B12,Vitaminas.PROTEINA,Vitaminas.E)
        AlimentosCadastrados.adicionarAlimento(Alimento("Ovo", Cores.BRANCO, 52.0, vitaminasOvo))
        adicionarAlimento(Alimento("Ovo", Cores.BRANCO, 52.0, vitaminasOvo))

        var vitaminasAtum = listOf(Vitaminas.PROTEINA,Vitaminas.POTASSIO,Vitaminas.MAGNESIO)
        AlimentosCadastrados.adicionarAlimento(Alimento("Atum", Cores.VERMELHO, 130.0, vitaminasAtum))
        adicionarAlimento(Alimento("Atum", Cores.VERMELHO, 130.0, vitaminasAtum))
    }

    override fun montarExercicios(){
        var musculosSupino = listOf(MusculosCorpo.TRICEPS, MusculosCorpo.PEITO)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Supino",musculosSupino,100.0,10))
        adicionarExercicio(Exercicio("Supino",musculosSupino,100.0,10))

        var musculosAbdominal = listOf(MusculosCorpo.ABDOMEN)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Abdominal",musculosAbdominal,100.0,10))
        adicionarExercicio(Exercicio("Abdominal",musculosAbdominal,100.0,10))

        var musculosLegPress = listOf(MusculosCorpo.PERNA, MusculosCorpo.PANTURRILHA)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("LegPress",musculosLegPress,100.0,10))
        adicionarExercicio(Exercicio("LegPress",musculosLegPress,100.0,10))

        var musculosRoscaDireta = listOf(MusculosCorpo.BICEPS, MusculosCorpo.ANTEBRACO)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Rosca Direta",musculosRoscaDireta,100.0,10))
        adicionarExercicio(Exercicio("Rosca Direta",musculosRoscaDireta,100.0,10))

        var musculosTricepsFrances = listOf(MusculosCorpo.TRICEPS)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Triceps Frances",musculosTricepsFrances,100.0,10))
        adicionarExercicio(Exercicio("Triceps Frances",musculosTricepsFrances,100.0,10))
    }

    override fun getTipo(): TiposObjetivos {
        return TiposObjetivos.HIPERTROFIA
    }
}