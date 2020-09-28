package objetivos

import entidades.Alimento
import entidades.Usuario
import enums.Cores
import enums.IMC
import enums.Vitaminas
import repositorio.Alimentos
import repositorio.Exercicios

class UsuarioFitness(nome: String,idade: Int, peso: Double,
                     altura: Double, cpf: String) : Usuario(nome,idade,peso,altura,cpf) {

    override fun montarDieta(){
        limparDieta()
        var vitaminasArrozIntegral = listOf(Vitaminas.FIBRAS, Vitaminas.ACIDOSGRAXOS, Vitaminas.B1, Vitaminas.B2, Vitaminas.B3, Vitaminas.B6)
        adicionarAlimento(Alimento("ArrozIntegral", Cores.BRANCO, 111.0, vitaminasArrozIntegral))

        var vitaminasFeijao = listOf(Vitaminas.B1, Vitaminas.B2, Vitaminas.B3, Vitaminas.B9, Vitaminas.FERRO)
        adicionarAlimento(Alimento("Feijao", Cores.MARROM, 76.0, vitaminasFeijao))

        var vitaminasSaladaAlface = listOf(Vitaminas.A)
        adicionarAlimento(Alimento("Salada de Alface", Cores.VERDE, 15.0, vitaminasSaladaAlface))

        var vitaminasSaladaBrocolis = listOf(Vitaminas.CALCIO,Vitaminas.POTASSIO,Vitaminas.FERRO,Vitaminas.ZINCO,Vitaminas.A,Vitaminas.C)
        adicionarAlimento(Alimento("Salada de Brocolis", Cores.VERDE, 25.0, vitaminasSaladaBrocolis))
    }
}