package objetivos

import entidades.Alimento
import entidades.Exercicio
import entidades.Usuario
import enums.MusculosCorpo
import enums.TiposObjetivos
import enums.Vitaminas
import interfaces.ObrigacoesUsuarioHipertrofico
import repositorio.companionObjects.AlimentosCadastrados
import repositorio.companionObjects.ExerciciosCadastrados

// Esta classe monta um usuário que possui objetivo hipertrofico de acordo
// com a sua gordura corporal, herdeira da classe Usuario

class UsuarioHipertrofico(
    usuario: Usuario
) : Usuario(
    usuario.getNome(),
    usuario.getIdade(),
    usuario.getPeso(),
    usuario.getAltura(),
    usuario.getCpf(),
    usuario.getFator()
), ObrigacoesUsuarioHipertrofico {

    private var tipoObjetivo: TiposObjetivos = TiposObjetivos.HIPERTROFIA

    override fun montarDieta() {
        limparDieta()

        var alimentos = AlimentosCadastrados.getAlimentos()

        for (x in alimentos) {
            adicionarAlimento(x)
        }

        tirarAlimentosSemProteina()
        somenteAlimentosComCarboidratos()
    }

    override fun montarTreino() {
        var exercicios = ExerciciosCadastrados.getExercicios()

        for (x in exercicios) {
            adicionarExercicio(x)
        }

        tirarExerciciosDeMuitaCaloria()
    }

    fun getTipo(): TiposObjetivos {
        return tipoObjetivo
    }

    override fun tirarExerciciosDeMuitaCaloria() {
        var exercicios = getTreino().getExercicios().filter { it.getCaloriasQueimadas() > 100.0 }

        for (x in exercicios) {
            removerExercicio(x.getNome())
        }
    }

    override fun tirarAlimentosSemProteina() {
        var alimentos = getDieta().getAlimentos().filter { !(it.getVitaminas().contains(Vitaminas.PROTEINA)) }

        for (x in alimentos) {
            removerAlimento(x.getNome())
        }
    }

    override fun somenteAlimentosComCarboidratos() {
        var alimentos = getDieta().getAlimentos().filter { !(it.getVitaminas().contains(Vitaminas.CARBOIDRATO)) }

        for (x in alimentos) {
            removerAlimento(x.getNome())
        }
    }

}