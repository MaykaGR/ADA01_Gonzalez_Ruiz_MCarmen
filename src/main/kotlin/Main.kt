import clasesUsuario.PropiedadesUsuario
import java.io.FileWriter
import java.io.Writer
import java.util.*

fun main() {
    /*val writer: Writer = FileWriter(System.getProperty("user.dir")+System.getProperty("file.separator")+
            "resources"+System.getProperty("file.separator")+"configuracion.conf")

    val propEscribir = Properties()

    propEscribir.setProperty("user","Pepito")
    propEscribir.setProperty("contrasenia","adsd")
    propEscribir.setProperty("desplazamiento","3324")
    propEscribir.setProperty("puerto","4354534534")

    propEscribir.store(writer, "Archivo de configuracion")*/

    /*var s = 'a'
     var f = s.toInt()+3
    s = f.toChar()
    println(s)*/

    var exit = false
    while(exit==false){
        println("¿Qué desea hacer?: 1- Mostrar keys de configuración  2- Modificar algún campo  3- Salir")
        var opcion = readln().toInt()
        if(opcion==1){println("1")}
        else if(opcion==2){
            var user = PropiedadesUsuario("uu","abc","","")
            println(user.descifrarPass())
        }
        else if(opcion==3){exit = true}
        else{println("Error")}
    }
}