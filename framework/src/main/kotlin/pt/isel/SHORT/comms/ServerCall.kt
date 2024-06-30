package pt.isel.SHORT.comms

import com.google.gson.Gson
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.Variable

typealias Action = (Request) -> Response

object ContractRegistry {
    val contracts: MutableList<Action> = mutableListOf()
}

/**
 * This is the base implementation of the server call function
 * Here is where all the logic lies, all the other serverCall functions are just overloads.
 * Which call this function with the correct parameters
 */
inline fun <R, reified T> JavaScript.baseServerCall(
    returnValue: Variable<R>? = null,
    parameter: Variable<T>? = null,
    crossinline callback: (T) -> R
): Variable<R>? {
    val actionHandler: (Request) -> Response = { request ->
        val body = request.bodyString()
        // Can only send a single parameter which maybe be an object containing all the data
        val result = if (parameter == null) {
            callback(null as T)
        } else {
            val variable = Gson().fromJson(body, T::class.java)
            callback(variable)
        }
        val responseContent = Gson().toJson(result)
        Response(Status.OK).body(responseContent)
    }

    // Register the contract
    ContractRegistry.contracts.add(actionHandler)
    val id = ContractRegistry.contracts.indexOf(actionHandler)

    // this appends the contract into the script
    val assignment = if (returnValue == null) "" else "${returnValue.reference} = "
    val payload = if (parameter == null) "" else ", ${parameter.reference}"
    append("${assignment}await serverCall($id$payload);")

    // Return the variable if it exists
    return returnValue
}

// () -> Unit
// () -> R
// (T) -> Unit
// (T) -> R

fun JavaScript.serverCall(
    callback: () -> Unit
) {
    baseServerCall<Unit, Unit>(callback = callback as (Unit) -> Unit)
}

fun <R> JavaScript.serverCall(
    returnValue: Variable<R>,
    callback: () -> R
): Variable<R> {
    return baseServerCall<R, Unit>(returnValue = returnValue, callback = callback as (Unit) -> R)!!
}

inline fun <reified T> JavaScript.serverCall(
    parameter: Variable<T>,
    crossinline callback: (T) -> Unit
) {
    baseServerCall<Unit, T>(parameter = parameter, callback = callback)
}

inline fun <R, reified T> JavaScript.serverCall(
    returnValue: Variable<R>,
    parameter: Variable<T>,
    crossinline callback: (T) -> R
): Variable<R> {
    return baseServerCall<R, T>(returnValue = returnValue, parameter = parameter, callback = callback)!!
}
