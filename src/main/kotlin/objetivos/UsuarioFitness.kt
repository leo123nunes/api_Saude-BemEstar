package objetivos

import entidades.Usuario
import enums.IMC
import repositorio.Alimentos
import repositorio.Exercicios

class UsuarioFitness(nome: String,idade: Int, peso: Double,
                     altura: Double, cpf: String) : Usuario(nome,idade,peso,altura,cpf) {

    override fun montarDieta(){}
}