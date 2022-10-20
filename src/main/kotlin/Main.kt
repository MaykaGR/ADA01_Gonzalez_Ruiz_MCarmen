import clasesUsuario.PropiedadesUsuario
import java.io.FileWriter
import java.io.Writer
import java.util.*

fun main() {
    var exit = false
    val prop = Properties()
    var usuario = PropiedadesUsuario()
    var writer: Writer = FileWriter(System.getProperty("user.dir")+System.getProperty("file.separator")+
            "resources"+System.getProperty("file.separator")+"configuracion.conf")
    prop.setProperty("user", usuario.user)
    prop.setProperty("password",usuario.password)
    prop.setProperty("port",usuario.port)
    prop.setProperty("server",usuario.server)
    prop.store(writer, "Creación de modelo")

    while(exit==false){
        println("¿Qué desea hacer?: 1- Mostrar keys de configuración  2- Modificar algún campo  3- Salir")
        var opcion = readln().toInt()
        if(opcion==1){
            val todasKeys = prop.propertyNames()
            val todasKeysAsList = todasKeys.toList()
            for(i in 0..todasKeysAsList.size-1){
                /*if(todasKeysAsList[i].toString() == "password"){
                    println("${todasKeysAsList[i]}: ${usuario.descifrarPass(prop.getProperty(todasKeysAsList[i].toString()))}")
                }*/
                //else{
                println("${todasKeysAsList[i]}: ${prop.getProperty(todasKeysAsList[i].toString())}")
                //}
            }
        }
        else if(opcion==2){
            println("¿Qué desea cambiar?: U- Usuario  P- Password  R- Port  S- Server")
            var campo = readln().toUpperCase()
            if(campo=="U"){
                println("Introduce nuevo valor: ")
                var valor = readln()
                var writer: Writer = FileWriter(System.getProperty("user.dir")+System.getProperty("file.separator")+
                        "resources"+System.getProperty("file.separator")+"configuracion.conf")
                usuario.user = valor
                prop.setProperty("user", usuario.user)
                prop.setProperty("password",usuario.password)
                prop.setProperty("port",usuario.port)
                prop.setProperty("server",usuario.server)
                prop.store(writer, "Cambio nombre de usuario")
            }
            else if(campo=="P"){
                println("Introduce la contraseña antigua: ")
                if(readln()== usuario.descifrarPass(usuario.password)){
                    println("Introduce nuevo valor: ")
                    var valor = readln()
                    var writer: Writer = FileWriter(System.getProperty("user.dir")+System.getProperty("file.separator")+
                        "resources"+System.getProperty("file.separator")+"configuracion.conf")
                    usuario.password = valor
                    prop.setProperty("user", usuario.user)
                    prop.setProperty("password",usuario.password)
                    prop.setProperty("port",usuario.port)
                    prop.setProperty("server",usuario.server)
                    prop.store(writer, "Cambio de password")}
                else {
                    println("Contraseña incorrecta")
                }
            }
            else if(campo=="R"){
                println("Introduce nuevo valor: ")
                var valor = readln()
                var writer: Writer = FileWriter(System.getProperty("user.dir")+System.getProperty("file.separator")+
                        "resources"+System.getProperty("file.separator")+"configuracion.conf")
                usuario.port = valor
                prop.setProperty("user", usuario.user)
                prop.setProperty("password",usuario.password)
                prop.setProperty("port",usuario.port)
                prop.setProperty("server",usuario.server)
                prop.store(writer, "Cambio de puerto")
            }
            else if(campo=="S"){
                println("Introduce nuevo valor: ")
                var valor = readln()
                var writer: Writer = FileWriter(System.getProperty("user.dir")+System.getProperty("file.separator")+
                        "resources"+System.getProperty("file.separator")+"configuracion.conf")
                usuario.server = valor
                prop.setProperty("user", usuario.user)
                prop.setProperty("password",usuario.password)
                prop.setProperty("port",usuario.port)
                prop.setProperty("server",usuario.server)
                prop.store(writer, "Cambio de server")
            }
            else{println("Campo no válido")}
        }
        else if(opcion==3){
            println("Adiós!")
            exit = true}
        else{println("Error")}
    }
}