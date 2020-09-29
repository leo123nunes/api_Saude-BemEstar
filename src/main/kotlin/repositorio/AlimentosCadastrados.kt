package repositorio

import entidades.Alimento
import entidades.Usuario
import enums.IMC

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