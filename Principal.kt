/**
 * Laboratorio 3
 * @author Brian Carrillo
 * @version 2.0
 *
 * Programación de Plataformas Móviles
 *
 */
// No tocar esta clase ---
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
    if (inputList == null) {
        return null
    } else {
        //Recorrido indexado de items en inputList
        inputList.forEachIndexed{ idx, value ->
            if (value != null) {
                val newItem: ItemData = when (value) {
                    is String -> ItemData(idx, value, "cadena", "L${value.length}")
                    is Int -> {
                        //Determinacion de la multiplicidad de value por 10,5 o 2
                        val num = listOf(10, 5, 2).firstOrNull { value % it == 0 }
                        ItemData(idx, value, "entero", if (num != null) "M${num}" else null)
                    }
                    is Boolean -> ItemData(idx, value, "booleano", if (value) "Verdadero" else "Falso")
                    else -> ItemData(idx, value, null, null)
                }
                resultado?.add(newItem)
            }
        }
        return resultado
    }
}