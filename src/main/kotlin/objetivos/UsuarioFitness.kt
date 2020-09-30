package objetivos

import entidades.Alimento
import entidades.Exercicio
import entidades.Usuario
import enums.MusculosCorpo
import enums.TiposObjetivos
import enums.Vitaminas
import interfaces.ObrigacoesUsuarioFitness
import repositorio.companionObjects.AlimentosCadastrados
import repositorio.companionObjects.ExerciciosCadastrados

// Esta classe monta um usuário que possui objetivo fitness de acordo
// com a sua gordura corporal, herdeira da classe Usuario

class UsuarioFitness(usuario: Usuario) : Usuario(
    usuario.getNome(),
    usuario.getIdade(),
    usuario.getPeso(),
    usuario.getAltura(),
    usuario.getCpf(),
    usuario.getFator()
), ObrigacoesUsuarioFitness {

    private var tipoObjetivo: TiposObjetivos = TiposObjetivos.FITNESS

    override fun montarDieta() {
        limparDieta()

        var alimentos = AlimentosCadastrados.getAlimentos()

        for (x in alimentos) {
            adicionarAlimento(x)
        }

        tirarAlimentosComGordura()
        tirarAlimentosMuitaCaloria()
    }

    override fun montarTreino() {

        var exercicios = ExerciciosCadastrados.getExercicios()

        for (x in exercicios) {
            adicionarExercicio(x)
        }

        tirarExerciciosDePoucaCaloria()
        fazerTreinoHIT()
    }

    fun getTipo(): TiposObjetivos {
        return tipoObjetivo
    }

    override fun tirarExerciciosDePoucaCaloria() {
        var exercicios = getTreino().getExercicios().filter { it.getCaloriasQueimadas() < 100.0 }

        for (x in exercicios) {
            removerExercicio(x.getNome())
        }
    }

    override fun tirarAlimentosComGordura() {
        var alimentos = getDieta().getAlimentos().filter { it.getVitaminas().contains(Vitaminas.GORDURA) }

        for (x in alimentos) {
            removerAlimento(x.getNome())
        }
    }

    override fun fazerTreinoHIT() {
        var exercicios = getTreino().getExercicios().filter { it.getNome() == "Treino Hit" }

        if (exercicios.isEmpty()) {
            adicionarExercicio(ExerciciosCadastrados.getExercicio("Treino Hit")!!)
        }
    }

    override fun tirarAlimentosMuitaCaloria() {
        var alimentos = getDieta().getAlimentos().filter { it.getCalorias() > 100.0 }

        for (x in alimentos) {
            removerAlimento(x.getNome())
        }
    }
}