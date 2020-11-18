package repositorio.companionObjects

import entidades.Alimento
import enums.Vitaminas

// Esta classe representa os alimentos cadastrados no sistema através
// de uma lista de Alimento.

class AlimentosCadastrados() {

    companion object {
        private var alimentos: MutableList<Alimento> = arrayListOf()

        fun adicionarAlimento(alimento: Alimento) {
            if(alimentos.filter{it.getNome()==alimento.getNome()}.isEmpty()){
                    alimentos.add(alimento)
            }
        }

        fun removerAlimento(nome: String) {
            alimentos.removeIf { it.getNome() == nome }
        }

        fun getAlimento(nome: String): Alimento?{
            for(x in alimentos){
                if (x.getNome() == nome){
                    return x
                }
            }

            return null
        }

        fun getAlimentos(): MutableList<Alimento> {
            return alimentos
        }

        fun inserirAlimentos(){
            var vitaminasArroz =
                listOf(Vitaminas.E, Vitaminas.B1, Vitaminas.B2, Vitaminas.B6, Vitaminas.B12, Vitaminas.CARBOIDRATO, Vitaminas.GORDURA)
            adicionarAlimento(Alimento("Arroz",95.0, vitaminasArroz))

            var vitaminasFeijao = listOf(Vitaminas.B1, Vitaminas.B2, Vitaminas.B3, Vitaminas.B9, Vitaminas.FERRO)
            adicionarAlimento(Alimento("Feijao", 76.0, vitaminasFeijao))

            var vitaminasCarne = listOf(Vitaminas.B1, Vitaminas.B2, Vitaminas.CARBOIDRATO, Vitaminas.PROTEINA, Vitaminas.GORDURA)
            adicionarAlimento(Alimento("Carne", 143.0, vitaminasCarne))

            var vitaminasSaladaAlface = listOf(Vitaminas.A)
            adicionarAlimento(Alimento("Salada de Alface",15.0, vitaminasSaladaAlface))

            var vitaminasPeixe =
                listOf(Vitaminas.CALCIO, Vitaminas.ZINCO, Vitaminas.B12, Vitaminas.PROTEINA, Vitaminas.CARBOIDRATO)
            adicionarAlimento(Alimento("Peixe", 206.0, vitaminasPeixe))

            var vitaminasBatataDoce = listOf(Vitaminas.CARBOIDRATO, Vitaminas.PROTEINA, Vitaminas.A)
            adicionarAlimento(Alimento("Batata Doce", 77.0, vitaminasBatataDoce))

            var vitaminasSardinha = listOf(Vitaminas.CALCIO, Vitaminas.D, Vitaminas.PROTEINA)
            adicionarAlimento(Alimento("Sardinha", 208.0, vitaminasSardinha))

            var vitaminasFrango = listOf(Vitaminas.B3, Vitaminas.FERRO, Vitaminas.PROTEINA, Vitaminas.CARBOIDRATO)
            adicionarAlimento(Alimento("Frango", 239.0, vitaminasFrango))

            var vitaminasArrozIntegral =
                listOf(Vitaminas.E, Vitaminas.B1, Vitaminas.B2, Vitaminas.B3, Vitaminas.K)
            adicionarAlimento(Alimento("Arroz Integral", 90.0, vitaminasArrozIntegral))

            var vitaminasSaladaTomate = listOf(Vitaminas.A, Vitaminas.FOSFORO, Vitaminas.POTASSIO)
            adicionarAlimento(Alimento("Salada Tomate", 25.0, vitaminasSaladaTomate))

            var vitaminasOvos = listOf(Vitaminas.A, Vitaminas.FOSFORO, Vitaminas.POTASSIO)
            adicionarAlimento(Alimento("Ovos", 45.0,vitaminasOvos))

            var vitaminasPeitodeFrango = listOf(Vitaminas.B, Vitaminas.ZINCO)
            adicionarAlimento(Alimento("Peito de Frango", 50.0, vitaminasPeitodeFrango))

            var vitaminasLaranja = listOf(Vitaminas.C, Vitaminas.CALCIO, Vitaminas.POTASSIO)
            adicionarAlimento(Alimento("Laranja", 65.0, vitaminasLaranja))

            var vitaminasAmendoas = listOf(Vitaminas.E, Vitaminas.B2)
            adicionarAlimento(Alimento("Amendôas", 25.0, vitaminasAmendoas))

            var vitaminasSalmao = listOf(Vitaminas.B3, Vitaminas.B12, Vitaminas.B3)
            adicionarAlimento(Alimento("Salmão", 243.0,  vitaminasSalmao))

            var vitaminasAtum = listOf(Vitaminas.A, Vitaminas.FOSFORO, Vitaminas.POTASSIO)
            adicionarAlimento(Alimento("Atum", 221.0, vitaminasAtum))

        }
    }
}