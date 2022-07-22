/**
 * Laboratorio 2
 * @author Brian Carrillo
 * @version 1.0
 *
 * Programación de Plataformas Móviles
 *
 */
// // No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", 10.20, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    //ArrayList inicializada como empty
    var resultado: ArrayList<ItemData>? = ArrayList<ItemData>()

    //Caso null
    if(inputList == null){
        resultado = null
        return resultado
        //Caso empty
    }else if(inputList.isEmpty()){
        return resultado
    }

    //Contador de posiciones
    var contador = 0
    for(item in inputList){
        //Evaluacion de tipo de entrada
        when(item){
            is String -> agregarString(resultado,contador,item)
            is Int -> agregarInt(resultado,contador,item)
            is Boolean -> agregarBoolean(resultado,contador,item)
            else -> if(item != null)agregarOtro(resultado,contador,item)
        }
        //Incremento del contador
        contador++
    }

    return resultado
}

//Funcion para agregar strings
fun agregarString(resultado:ArrayList<ItemData>?,pos:Int,value:String):Unit {
    val newItem = ItemData(
        originalPos = pos,
        originalValue = value,
        type = "cadena",
        info = "L"+ value.length
    )
    resultado?.add(newItem)
}

//Funcion para agregar enteros
fun agregarInt(resultado:ArrayList<ItemData>?,pos:Int,value:Int):Unit {
    val newItem = ItemData(
        originalPos = pos,
        originalValue = value,
        type = "entero",
        info = if((value%10)==0) "M10" else if((value%5)==0) "M5" else if((value%2)==0) "M2" else null
    )
    resultado?.add(newItem)
}

//Funcion para agregar booleanos
fun agregarBoolean(resultado:ArrayList<ItemData>?,pos:Int,value:Boolean):Unit {
    val newItem = ItemData(
        originalPos = pos,
        originalValue = value,
        type = "booleano",
        info = if(value) "Verdadero" else "Falso"
    )
    resultado?.add(newItem)
}

//Funcion para agregar otros
fun agregarOtro(resultado:ArrayList<ItemData>?,pos:Int,value:Any):Unit {
    val newItem = ItemData(
        originalPos = pos,
        originalValue = value,
        type = null,
        info = null
    )
    resultado?.add(newItem)
}