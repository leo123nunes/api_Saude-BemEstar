package repositorio.companionObjects

import entidades.Alimento

// Esta classe representa os alimentos cadastrados no sistema através
// de uma lista de Alimento.

class AlimentosCadastrados() {

    companion object{
        private var alimentos: MutableList<Alimento> = arrayListOf()

        fun adicionarAlimento(alimento: Alimento){
            alimentos.add(alimento)
        }

        fun removerAlimento(nome: String){
            alimentos.removeIf{it.getNome()==nome}
        }

        fun getAlimentos(): MutableList<Alimento>{
            return alimentos
        }
    }
}