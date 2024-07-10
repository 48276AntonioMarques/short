package pt.isel.SHORT.client.`object`

import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.JsObject
import pt.isel.SHORT.client.Variable

/**
 * Represents the Storage object in JavaScript
 *  * Implementation according to [Storage - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/Storage)
 */
class Storage(private val value: String, private val script: JavaScript) : JsObject {
    override fun toJs(): String = value

    /**
     * Returns an integer representing the number of data items stored in the Storage object.
     */
    val length = script.registerProperty(0, "${toJs()}.length;")

    /**
     * When passed a number n, this method will return the name of the nth key in the storage.
     */
    fun key(result: Variable<String>, n: Variable<Int>) {
        script.append("${result.reference} = $value.key($n);")
    }

    /**
     * When passed a key name, will return that key's value.
     */
    fun getItem(result: Variable<String>, name: Variable<String>) {
        script.append("${result.reference} = $value.getItem(${name.reference});")
    }

    /**
     * When passed a key name and value, will add that key to the storage, or update that key's value if it already exists.
     */
    fun setItem(name: Variable<String>, value: Variable<String>) {
        script.append("${toJs()}.setItem(${name.reference}, ${value.reference});")
    }

    /**
     * When passed a key name, will remove that key from the storage.
     */
    fun removeItem(name: Variable<String>) {
        script.append("${toJs()}.removeItem(${name.reference});")
    }

    /**
     * When invoked, will empty all keys out of the storage.
     */
    fun clear() {
        script.append("${toJs()}.clear();")
    }
}
