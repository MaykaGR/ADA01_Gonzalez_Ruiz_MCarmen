package clasesUsuario

import java.lang.IllegalArgumentException

class PropiedadesUsuario(user: String = "Usuario", password: String = "abc", port: String = "1", server: String = "1") {
    var user: String = user
        set(value){
            if(user.isEmpty()) throw IllegalArgumentException()
            field = value
        }
    init {
        this.user = user
    }
    var password: String = password
        set(value){
            if(password.isEmpty()) throw IllegalArgumentException()
            field = cifrarPass(value)
        }
    init {
        this.password = password
    }
    var port: String = port
    var server: String = server

    fun cifrarPass(value: String): String{
        var pass = value.toCharArray()
        var cont = value
        for(i in 0..pass.size-1){
            pass[i] = (pass[i].toInt()+3).toChar()
            cont += pass[i]
        }
        cont = cont.removePrefix(value)
        return cont
    }

    fun descifrarPass(value: String): String{
        var pass = value.toCharArray()
        var cont = value
        for(i in 0..pass.size-1){
            pass[i] = (pass[i].toInt()-3).toChar()
            cont += pass[i]
        }
        cont = cont.removePrefix(value)
        return cont
    }

    override fun toString(): String {
        return "$user,$password,$port,$server"
    }
}