package entidades

import enums.Cores
import enums.IMC
import enums.PartesCorpo
import enums.Vitaminas
import repositorio.Alimentos
import repositorio.Exercicios

open class Usuario(private var nome: String,private var idade: Int,
                   private var peso: Double,private var altura: Double,
                   private var cpf: String) {

    private var exercicios: Exercicios = Exercicios()
    private var dieta: Alimentos = Alimentos()
    private var grauIMC: IMC = grauIMC()

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
        exercicios.adicionarExercicio(exercicio)
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
        var musculosEsteira = listOf(PartesCorpo.PERNA,PartesCorpo.PANTURRILHA)
        exercicios.adicionarExercicio(Exercicio("Esteira",musculosEsteira))

        var musculosBicicleta = listOf(PartesCorpo.ABDOMEN,PartesCorpo.PANTURRILHA,PartesCorpo.PERNA)
        exercicios.adicionarExercicio(Exercicio("Bicicleta",musculosBicicleta))

        var musculosAbdominal = listOf(PartesCorpo.ABDOMEN)
        exercicios.adicionarExercicio(Exercicio("Abdominal",musculosAbdominal))

        var musculosFlexao = listOf(PartesCorpo.TRICEPS,PartesCorpo.PEITO)
        exercicios.adicionarExercicio(Exercicio("Flexão",musculosFlexao))
    }
}