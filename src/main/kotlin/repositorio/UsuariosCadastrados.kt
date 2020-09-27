package repositorio
import entidades.Exercicios
import entidades.Usuarios
import enums.GrauIMC

class UsuariosCadastrados {
    private lateinit var usuarios: MutableList<Usuarios>

    fun adicionarUsuario(usuario: Usuarios){
        usuarios.add(usuario)
    }

    fun removerUsuario(nome: String){
        usuarios.removeIf{it.nome==nome}
    }

    fun getUsuariosImcAll(): MutableList<Usuarios>{
        return usuarios
    }

    fun getUsuariosImcAbaixo(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == GrauIMC.ABAIXO}
    }

    fun getUsuariosImcNormal(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == GrauIMC.NORMAL}
    }

    fun getUsuariosImcSobrepeso(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == GrauIMC.SOBREPESO}
    }

    fun getUsuariosImcObesidade1(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == GrauIMC.OBESIDADE1}
    }

    fun getUsuariosImcObesidade2(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == GrauIMC.OBESIDADE2}
    }

    fun getUsuariosImcObesidade3(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == GrauIMC.OBESIDADE3}
    }
}