package entidades

import enums.*
import entidades.pertencesUsuario.DietaAlimentos
import entidades.pertencesUsuario.TreinoExercicios
import repositorio.companionObjects.AlimentosCadastrados
import repositorio.companionObjects.ExerciciosCadastrados

// Esta classe representa o usuario padrão do sistema

open class Usuario(private val nome: String,private var idade: Int,
                   private var peso: Double,private var altura: Double,
                   private val cpf: String, private var fator: Double) {

    private var treinoExercicios: TreinoExercicios
    private var dieta: DietaAlimentos
    private var grauIMC: IMC = grauIMC()
    private var porcentagemGorduraCorpotal = calcularIMC()
    private var necessidadeEnergetica = necessidadeEnergetica()
    private var caloriasIngeridasDiariamente: Double
    private var caloriasQueimadasDiariamente: Double

    init{
        this.dieta = DietaAlimentos()
        this.treinoExercicios = TreinoExercicios()
        montarExercicios()
        montarDieta()
        this.caloriasIngeridasDiariamente = dieta.getTotalCaloriasIngeridas()
        this.caloriasQueimadasDiariamente = treinoExercicios.getTotalCaloriasQueimadas()
    }

    fun setCaloriasQueimadasDiariamente(){
        caloriasQueimadasDiariamente =  treinoExercicios.getTotalCaloriasQueimadas()
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

    fun limparExercicios(){
        treinoExercicios.limparExercicios()
    }

    fun adicionarAlimento(alimento: Alimento){
        dieta.adicionarAlimento(alimento)
    }

    fun removerAlimento(nome: String){
        dieta.removerAlimento(nome)
    }

    fun removerExercicio(nome: String){
        treinoExercicios.removerExercicio(nome)
    }

    fun adicionarExercicio(exercicio: Exercicio){
        treinoExercicios.adicionarExercicio(exercicio)
    }

    fun necessidadeEnergetica(): Double{
        var energia: Double = 135.3 - (30.8 * idade) + fator * (10 * peso + 934 * altura) + 25
        println("Sua Necessidade Energetica é de $energia Kcal")
        return energia
    }

    open fun montarDieta(){
        var vitaminasArroz = listOf(Vitaminas.E,Vitaminas.B1,Vitaminas.B2,Vitaminas.B6,Vitaminas.B12,Vitaminas.CARBOIDRATO)
        AlimentosCadastrados.adicionarAlimento(Alimento("Arroz", Cores.BRANCO, 130.0, vitaminasArroz))
        dieta.adicionarAlimento(Alimento("Arroz", Cores.BRANCO, 130.0, vitaminasArroz))

        var vitaminasFeijao = listOf(Vitaminas.B1,Vitaminas.B2,Vitaminas.B3,Vitaminas.B9,Vitaminas.FERRO)
        AlimentosCadastrados.adicionarAlimento(Alimento("Feijao", Cores.MARROM, 76.0, vitaminasFeijao))
        dieta.adicionarAlimento(Alimento("Feijao", Cores.MARROM, 76.0, vitaminasFeijao))

        var vitaminasCarne = listOf(Vitaminas.B1,Vitaminas.B2,Vitaminas.B3,Vitaminas.PROTEINA,Vitaminas.GORDURA)
        AlimentosCadastrados.adicionarAlimento(Alimento("Carne", Cores.VERMELHO, 143.0, vitaminasCarne))
        dieta.adicionarAlimento(Alimento("Carne", Cores.VERMELHO, 143.0, vitaminasCarne))

        var vitaminasSaladaAlface = listOf(Vitaminas.A)
        AlimentosCadastrados.adicionarAlimento(Alimento("Salada de Alface", Cores.VERDE, 15.0, vitaminasSaladaAlface))
        dieta.adicionarAlimento(Alimento("Salada de Alface", Cores.VERDE, 15.0, vitaminasSaladaAlface))
    }

    open fun montarExercicios(){
        var musculosEsteira = listOf(MusculosCorpo.PERNA,MusculosCorpo.PANTURRILHA)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Esteira",musculosEsteira,700.0,10))
        treinoExercicios.adicionarExercicio(Exercicio("Esteira",musculosEsteira,700.0,10))

        var musculosBicicleta = listOf(MusculosCorpo.ABDOMEN,MusculosCorpo.PANTURRILHA,MusculosCorpo.PERNA)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Bicicleta",musculosBicicleta, 540.0,10))
        treinoExercicios.adicionarExercicio(Exercicio("Bicicleta",musculosBicicleta, 540.0,10))

        var musculosAbdominal = listOf(MusculosCorpo.ABDOMEN)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Abdominal",musculosAbdominal, 588.0,10))
        treinoExercicios.adicionarExercicio(Exercicio("Abdominal",musculosAbdominal, 588.0,10))

        var musculosFlexao = listOf(MusculosCorpo.TRICEPS,MusculosCorpo.PEITO)
        ExerciciosCadastrados.adicionarExercicio(Exercicio("Flexão",musculosFlexao,100.0,10))
        treinoExercicios.adicionarExercicio(Exercicio("Flexão",musculosFlexao,100.0,10))
    }

    open fun getTipo(): TiposObjetivos{
        return TiposObjetivos.NORMAL
    }
}