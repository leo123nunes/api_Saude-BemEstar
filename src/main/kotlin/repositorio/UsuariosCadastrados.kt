package repositorio
import entidades.Exercicios
import entidades.Usuarios

class UsuariosCadastrados {
    private lateinit var usuarios: MutableList<Usuarios>

    fun adicionarUsuario(usuario: Usuarios){
        usuarios.add(usuario)
    }

    fun removerUsuario(nome: String){
        usuarios.removeIf{it.nome==nome}
    }

    fun getUsuarios(): MutableList<Usuarios>{
        return usuarios
    }
}