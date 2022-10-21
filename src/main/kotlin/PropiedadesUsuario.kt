package clasesUsuario

import java.lang.IllegalArgumentException

//Clase que crea el modelo de usuario y asigna valores por defecto a las propiedades
class PropiedadesUsuario(user: String = "Usuario", password: String = "abc", port: String = "1", server: String = "1") {
    var user: String = user
        //Setter que no permite que user esté vacío
        set(value){
            if(user.isEmpty()) throw IllegalArgumentException()
            field = value
        }
    init {
        this.user = user
    }
    var password: String = password
        //Setter que no permite que password esté vacío, y cifra la contraseña introducida para guardarla cifrada
        set(value){
            if(password.isEmpty()) throw IllegalArgumentException()
            field = cifrarPass(value)
        }
    init {
        this.password = password
    }
    var port: String = port
    var server: String = server

    //Función que obtiene la contraseña y la cifra
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

    //Función que obtiene la contraseña cifrada y la descifra
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