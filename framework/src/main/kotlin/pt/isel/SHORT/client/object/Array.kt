package pt.isel.SHORT.client.`object`

import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.JsObject
import pt.isel.SHORT.client.Var
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.client.get
import pt.isel.SHORT.html.base.Body
import pt.isel.SHORT.html.base.Html
import pt.isel.SHORT.html.base.Script

/**
 * Represents the Array object in JavaScript
 *  * Implementation according to [Array - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array)
 */
class Array(private val script: JavaScript) : JsObject {
    override fun toJs(): String = "Array"

    /**
     * The Array.isArray() static method determines whether the passed value is an Array.
     */
    fun isArray(result: Variable<Boolean>, array: Variable<*>) {
        script.append("${result.reference} = ${toJs()}.isArray(${array.reference});")
    }

    /**
     * The Array.of() static method creates a new Array instance from a variable number of arguments,
     * regardless of number or type of the arguments.
     */
    fun <T> of(result: Variable<kotlin.Array<T>>, vararg elements: Variable<T>) {
        script.append("${result.reference} = ${toJs()}.of(${elements.joinToString(",") { it.reference }});")
    }

    /** From here down is the operations to the arrays that are framework specific */

    /**
     * This function is framework specific (which means it is not part of the JavaScript Array object)
     * It is used to get a value from an array into a variable.
     * @param result The variable that will hold the value from the array.
     * @sample getValueFromArray
     */
    fun <T> get(result: Variable<T>, array: ArrayGet<T>) {
        script.append("${result.reference} = ${array.array.reference}[${array.index.reference}];")
    }
}

class ArrayGet<T>(val array: Variable<kotlin.Array<T>>, val index: Variable<Int>)

fun getValueFromArray() {
    Html {
        Body {
            Script {
                val array = Var(arrayOf(1, 2, 3))
                val index = Var(0)
                val result = Var(0)
                Array.get(result, array[index])
            }
        }
    }
}
