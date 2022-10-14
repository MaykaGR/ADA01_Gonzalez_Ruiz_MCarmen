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
            field = value
        }
    init {
        this.password = cifrarPass()
    }
    var port: String = port
    var server: String = server

    fun cifrarPass(): String{
        var pass = password.toCharArray()
        var cont = password
        for(i in 0..pass.size-1){
            pass[i] = (pass[i].toInt()+3).toChar()
            cont += pass[i]
        }
        cont = cont.removePrefix(password)
        return cont
    }

    fun descifrarPass(): String{
        var pass = password.toCharArray()
        var cont = password
        for(i in 0..pass.size-1){
            pass[i] = (pass[i].toInt()-3).toChar()
            cont += pass[i]
        }
        cont = cont.removePrefix(password)
        return cont
    }

    override fun toString(): String {
        return "$user,$password,$port,$server"
    }
}