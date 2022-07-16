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
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var resultado: ArrayList<ItemData>? = ArrayList<ItemData>()

    if(inputList == null){
        resultado = null
        return resultado
    }else if(inputList.isEmpty()){
        return resultado
    }

    var contador = 0
    for(item in inputList){
        when(item){
            is String -> agregarString(resultado,contador,item)
            is Int -> agregarInt(resultado,contador,item)
            is Boolean -> agregarBoolean(resultado,contador,item)
            else -> if(item != null)agregarOtro(resultado,contador,item)
        }
        contador++
    }

    return resultado
}

fun agregarString(resultado:ArrayList<ItemData>?,pos:Int,value:String):Unit {
    val newItem = ItemData(
        originalPos = pos,
        originalValue = value,
        type = "cadena",
        info = "L"+ value.length
    )
    resultado?.add(newItem)
}

fun agregarInt(resultado:ArrayList<ItemData>?,pos:Int,value:Int):Unit {
    val newItem = ItemData(
        originalPos = pos,
        originalValue = value,
        type = "entero",
        info = if((value%10)==0) "M10" else if((value%5)==0) "M5" else if((value%2)==0) "M2" else null
    )
    resultado?.add(newItem)
}

fun agregarBoolean(resultado:ArrayList<ItemData>?,pos:Int,value:Boolean):Unit {
    val newItem = ItemData(
        originalPos = pos,
        originalValue = value,
        type = "booleano",
        info = if(value) "Verdadero" else "Falso"
    )
    resultado?.add(newItem)
}

fun agregarOtro(resultado:ArrayList<ItemData>?,pos:Int,value:Any):Unit {
    val newItem = ItemData(
        originalPos = pos,
        originalValue = value,
        type = null,
        info = null
    )
    resultado?.add(newItem)
}
