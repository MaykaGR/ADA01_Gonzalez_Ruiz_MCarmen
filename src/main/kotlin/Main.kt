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
            println(todasKeysAsList)
        }
        else if(opcion==2){
            println("¿Qué desea cambiar?: U- Usuario  P- Password  R- Port  S- Server")
            var campo = readln().toUpperCase()
            println("Introduce nuevo valor: ")
            var valor = readln()
            if(campo=="U"){
               prop.setProperty(prop.getProperty("user"),valor)
                prop.store(writer, "Cambio de usuario")
            }
            else if(campo=="P"){
                prop.setProperty(prop.getProperty("password"),valor)
                prop.store(writer, "Cambio de password")
            }
            else if(campo=="R"){
                prop.setProperty(prop.getProperty("port"),valor)
                prop.store(writer, "Cambio de puerto")
            }
            else if(campo=="S"){
                prop.setProperty(prop.getProperty("server"),valor)
                prop.store(writer, "Cambio de server")
            }
            else{println("Valor no válido")}
        }
        else if(opcion==3){exit = true}
        else{println("Error")}
    }
}