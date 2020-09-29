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

// Esta classe monta um usuário que possui objetivo fitness de acordo
// com a sua gordura corporal, herdeira da classe Usuario

class UsuarioFitness(nome: String,idade: Int, peso: Double,
                     altura: Double, cpf: String, fator: Double) : Usuario(nome,idade,peso,altura,cpf,fator) {

    private val tipoObjetivo = TiposObjetivos.FITNESS

    override fun montarDieta(){
        limparDieta()
        var vitaminasArrozIntegral = listOf(Vitaminas.FIBRAS, Vitaminas.ACIDOSGRAXOS, Vitaminas.B1, Vitaminas.B2, Vitaminas.B3, Vitaminas.B6)
        AlimentosCadastrados.adicionarAlimento(Alimento("ArrozIntegral", Cores.BRANCO, 111.0, vitaminasArrozIntegral))
        adicionarAlimento(Alimento("ArrozIntegral", Cores.BRANCO, 111.0, vitaminasArrozIntegral))

        var vitaminasFeijao = listOf(Vitaminas.B1, Vitaminas.B2, Vitaminas.B3, Vitaminas.B9, Vitaminas.FERRO)
        AlimentosCadastrados.adicionarAlimento(Alimento("Feijao", Cores.MARROM, 76.0, vitaminasFeijao))
        adicionarAlimento(Alimento("Feijao", Cores.MARROM, 76.0, vitaminasFeijao))

        var vitaminasSaladaAlface = listOf(Vitaminas.A)
        AlimentosCadastrados.adicionarAlimento(Alimento("Salada de Alface", Cores.VERDE, 15.0, vitaminasSaladaAlface))
        adicionarAlimento(Alimento("Salada de Alface", Cores.VERDE, 15.0, vitaminasSaladaAlface))

        var vitaminasSaladaBrocolis = listOf(Vitaminas.CALCIO,Vitaminas.POTASSIO,Vitaminas.FERRO,Vitaminas.ZINCO,Vitaminas.A,Vitaminas.C)
        AlimentosCadastrados.adicionarAlimento(Alimento("Salada de Brocolis", Cores.VERDE, 25.0, vitaminasSaladaBrocolis))
        adicionarAlimento(Alimento("Salada de Brocolis", Cores.VERDE, 25.0, vitaminasSaladaBrocolis))
    }

    override fun montarExercicios(){
        var musculosBicicleta = listOf(MusculosCorpo.ABDOMEN, MusculosCorpo.PANTURRILHA, MusculosCorpo.PERNA)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Bicicleta",musculosBicicleta,100.0,10))
        adicionarExercicio(Exercicio("Bicicleta",musculosBicicleta,100.0,10))

        var musculosAbdominal = listOf(MusculosCorpo.ABDOMEN)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Abdominal",musculosAbdominal,200.0,10))
        adicionarExercicio(Exercicio("Abdominal",musculosAbdominal,200.0,10))

        var musculosTreinoHit = listOf(MusculosCorpo.PERNA, MusculosCorpo.PANTURRILHA,MusculosCorpo.ABDOMEN)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Treino Hit",musculosTreinoHit,300.0,10))
        adicionarExercicio(Exercicio("Treino Hit",musculosTreinoHit,300.0,10))
    }

    override fun getTipo(): TiposObjetivos {
        return TiposObjetivos.FITNESS
    }
}