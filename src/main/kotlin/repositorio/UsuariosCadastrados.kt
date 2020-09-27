package repositorio
import entidades.Usuarios
import enums.IMCGrau

class UsuariosCadastrados {
    private var usuarios: MutableList<Usuarios> = arrayListOf()

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
        return usuarios.filter{it.verificaPeso() == IMCGrau.ABAIXO}
    }

    fun getUsuariosImcNormal(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == IMCGrau.NORMAL}
    }

    fun getUsuariosImcSobrepeso(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == IMCGrau.SOBREPESO}
    }

    fun getUsuariosImcObesidade1(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == IMCGrau.OBESIDADE1}
    }

    fun getUsuariosImcObesidade2(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == IMCGrau.OBESIDADE2}
    }

    fun getUsuariosImcObesidade3(): List<Usuarios>{
        return usuarios.filter{it.verificaPeso() == IMCGrau.OBESIDADE3}
    }
}