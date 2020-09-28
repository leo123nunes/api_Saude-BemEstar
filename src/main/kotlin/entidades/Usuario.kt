package entidades

import enums.Cores
import enums.IMC
import enums.MusculosCorpo
import enums.Vitaminas
import repositorio.RotinaAlimentos
import repositorio.RotinaExercicios

open class Usuario(private var nome: String,private var idade: Int,
                   private var peso: Double,private var altura: Double,
                   private var cpf: String, private var fator: Double) {

    private var rotinaExercicios: RotinaExercicios = RotinaExercicios()
    private var dieta: RotinaAlimentos = RotinaAlimentos()
    private var grauIMC: IMC = grauIMC()
    private var porcentagemGorduraCorpotal = calcularIMC()
    private var necessidadeEnergetica = necessidade()

    init{
        this.montarExercicios()
        this.montarDieta()
    }

    fun getCpf(): String{
        return cpf
    }

    fun getNome(): String{
        return nome
    }

    fun getPeso(): Double{
        return peso
    }

    fun getAltura(): Double{
        return altura
    }

    fun getIdade(): Int{
        return idade
    }

    fun getFator(): Double{
        return fator
    }

    fun calcularIMC(): Double{
        return peso / (altura*altura)
    }

    fun grauIMC(): IMC{
        var imc = calcularIMC()
        return when{
            imc < 18.5 -> IMC.ABAIXO
            imc > 18.5 && imc < 24.9 -> IMC.NORMAL
            imc > 25 && imc < 29.9 -> IMC.SOBREPESO
            imc > 30 && imc < 34.9 -> IMC.OBESIDADE1
            imc > 35 && imc < 39.9 -> IMC.OBESIDADE2
            else -> IMC.OBESIDADE3
        }
    }

    fun limparDieta(){
        dieta.limparAlimentos()
    }

    fun adicionarAlimento(alimento: Alimento){
        dieta.adicionarAlimento(alimento)
    }

    fun adicionarExercicio(exercicio: Exercicio){
        rotinaExercicios.adicionarExercicio(exercicio)
    }

    fun necessidade(): Double{
        var energia: Double = 135.3 - (30.8 * idade) + fator * (10 * peso + 934 * altura) + 25
        println("Sua Necessidade Energetica é de $energia Kcal")
        return energia
    }

    open fun montarDieta(){
        var vitaminasArroz = listOf(Vitaminas.E,Vitaminas.B1,Vitaminas.B2,Vitaminas.B6,Vitaminas.B12,Vitaminas.CARBOIDRATO)
        dieta.adicionarAlimento(Alimento("Arroz", Cores.BRANCO, 130.0, vitaminasArroz))

        var vitaminasFeijao = listOf(Vitaminas.B1,Vitaminas.B2,Vitaminas.B3,Vitaminas.B9,Vitaminas.FERRO)
        dieta.adicionarAlimento(Alimento("Feijao", Cores.MARROM, 76.0, vitaminasFeijao))

        var vitaminasCarne = listOf(Vitaminas.B1,Vitaminas.B2,Vitaminas.B3,Vitaminas.PROTEINA,Vitaminas.GORDURA)
        dieta.adicionarAlimento(Alimento("Carne", Cores.VERMELHO, 143.0, vitaminasCarne))

        var vitaminasSaladaAlface = listOf(Vitaminas.A)
        dieta.adicionarAlimento(Alimento("Salada de Alface", Cores.VERDE, 15.0, vitaminasSaladaAlface))
    }

    open fun montarExercicios(){
        var musculosEsteira = listOf(MusculosCorpo.PERNA,MusculosCorpo.PANTURRILHA)
        rotinaExercicios.adicionarExercicio(Exercicio("Esteira",musculosEsteira))

        var musculosBicicleta = listOf(MusculosCorpo.ABDOMEN,MusculosCorpo.PANTURRILHA,MusculosCorpo.PERNA)
        rotinaExercicios.adicionarExercicio(Exercicio("Bicicleta",musculosBicicleta))

        var musculosAbdominal = listOf(MusculosCorpo.ABDOMEN)
        rotinaExercicios.adicionarExercicio(Exercicio("Abdominal",musculosAbdominal))

        var musculosFlexao = listOf(MusculosCorpo.TRICEPS,MusculosCorpo.PEITO)
        rotinaExercicios.adicionarExercicio(Exercicio("Flexão",musculosFlexao))
    }
}