import clasesUsuario.PropiedadesUsuario
import java.io.FileWriter
import java.io.Writer
import java.util.*

fun main() {
    //Variable para salir del programa
    var exit = false
    //Instancia de properties
    val prop = Properties()
    var usuario = PropiedadesUsuario()
    //Creación de un writer con un archivo de configuración
    var writer: Writer = FileWriter(System.getProperty("user.dir")+System.getProperty("file.separator")+
            "resources"+System.getProperty("file.separator")+"configuracion.conf")
    //Se asignan las propiedades de usuario por defecto
    prop.setProperty("user", usuario.user)
    prop.setProperty("password",usuario.password)
    prop.setProperty("port",usuario.port)
    prop.setProperty("server",usuario.server)
    //Se crea el fichero de configuración estándar
    prop.store(writer, "Creación de modelo")

    //Entrada a la interacción con el usuario, que se repetirá hasta que se introduzca el 3
    while(exit==false){
        println("¿Qué desea hacer?: 1- Mostrar keys de configuración  2- Modificar algún campo  3- Salir")
        var opcion = readln().toInt()
        //Si el valor introducido es 1, se muestra el contenido que esté en el archivo de configuración
        if(opcion==1){
            val todasKeys = prop.propertyNames()
            val todasKeysAsList = todasKeys.toList()
            //Comentado se encuentra cómo se haría si se quisiera que la contraseña se mostrara por pantalla sin cifrar
            for(i in 0..todasKeysAsList.size-1){
                /*if(todasKeysAsList[i].toString() == "password"){
                    println("${todasKeysAsList[i]}: ${usuario.descifrarPass(prop.getProperty(todasKeysAsList[i].toString()))}")
                }*/
                //else{
                println("${todasKeysAsList[i]}: ${prop.getProperty(todasKeysAsList[i].toString())}")
                //}
            }
        }
        //Si el valor introducido es 2, se pide el campo que se desea cambiar
        else if(opcion==2){
            println("¿Qué desea cambiar?: U- Usuario  P- Password  R- Port  S- Server")
            var campo = readln().toUpperCase()
            //Si el campo es el de usuario, se pide el nuevo valor a introducir en usuario y se cambia esta propiedad en la variable usuario, y se reescribe
            //el archivo de configuración con los datos actualizados
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
            //Si el campo es la contraseña, se pide la contraseña antigua, en caso de que se introduzca la contraseña correcta
            // se pide el nuevo valor a introducir, se cambia esta propiedad en la variable usuario, y se reescribe
            //el archivo de configuración con los datos actualizados
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
            //Si el campo es el de puerto, se pide el nuevo valor a introducir en puerto y se cambia esta propiedad en la variable usuario, y se reescribe
            //el archivo de configuración con los datos actualizados
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
            //Si el campo es el de servidor, se pide el nuevo valor a introducir en servidor y se cambia esta propiedad en la variable usuario, y se reescribe
            //el archivo de configuración con los datos actualizados
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
        //Al introducir el 3, exit pasa a true y se sale de la aplicación
        else if(opcion==3){
            println("Adiós!")
            exit = true}
        else{println("Error")}
    }
}