package entidades.pertencesUsuario

import entidades.Alimento
import repositorio.companionObjects.AlimentosCadastrados

// Esta classe representa a dieta através de uma lista de alimentos
// de cada usuário

class DietaAlimentos {
    private var alimentos: MutableList<Alimento> = mutableListOf()
    private var totalCaloriasIngeridas = 0.0

    fun adicionarAlimento(alimento: Alimento) {
        alimentos.add(alimento)
        totalCaloriasIngeridas += alimento.getCalorias()
    }

    fun getTotalCaloriasIngeridas(): Double {
        return totalCaloriasIngeridas
    }

    fun limparAlimentos() {
        alimentos.clear()
    }

    fun removerAlimento(nome: String) {
        var alimento = AlimentosCadastrados.getAlimento(nome)
        alimentos.removeIf { it.getNome() == nome }
        totalCaloriasIngeridas -= alimento!!.getCalorias()
    }

    fun getAlimentos(): MutableList<Alimento> {
        return alimentos
    }
}