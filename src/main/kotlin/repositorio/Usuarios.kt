package repositorio
import entidades.Usuario
import enums.IMC

class Usuarios {
    private var usuarios: MutableList<Usuario> = arrayListOf()

    fun adicionarUsuario(usuario: Usuario){
        usuarios.add(usuario)
    }

    fun removerUsuario(nome: String){
        usuarios.removeIf{it.getNome()==nome}
    }

    fun getUsuariosImcAll(): MutableList<Usuario>{
        return usuarios
    }

    fun getUsuariosImcAbaixo(): List<Usuario>{
        return usuarios.filter{it.grauIMC() == IMC.ABAIXO}
    }

    fun getUsuariosImcNormal(): List<Usuario>{
        return usuarios.filter{it.grauIMC() == IMC.NORMAL}
    }

    fun getUsuariosImcSobrepeso(): List<Usuario>{
        return usuarios.filter{it.grauIMC() == IMC.SOBREPESO}
    }

    fun getUsuariosImcObesidade1(): List<Usuario>{
        return usuarios.filter{it.grauIMC() == IMC.OBESIDADE1}
    }

    fun getUsuariosImcObesidade2(): List<Usuario>{
        return usuarios.filter{it.grauIMC() == IMC.OBESIDADE2}
    }

    fun getUsuariosImcObesidade3(): List<Usuario>{
        return usuarios.filter{it.grauIMC() == IMC.OBESIDADE3}
    }
}