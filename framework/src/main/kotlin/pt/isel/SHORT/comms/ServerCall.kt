package pt.isel.SHORT.comms

import com.google.gson.Gson
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.Variable

/**
 * Represents a server call.
 */
typealias Action = (Request) -> Response

/**
 * Represents the id of a contract.
 * A contract is the representation of a server call,
 * which describes the action to be executed on the server,
 * as well as how to convert the request body into an object.
 */
typealias ContractID = Int

// FIXME: This shouldn't exist, this values must be accessed through the Javascript object
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

/**
 * Used to execute code on the server.
 * This call is synchronous so the call-site will block until the server responds.
 * @param callback the code to be executed on the server.
 */
fun JavaScript.serverCall(
    callback: () -> Unit
) {
    baseServerCall<Unit, Unit>(callback = callback as (Unit) -> Unit)
}

/**
 * Used to execute code on the server, that returns a value.
 * This call is synchronous so the call-site will block until the server responds.
 * @param callback the code to be executed on the server.
 * @return the return value of the server call.
 */
fun <R> JavaScript.serverCall(
    returnValue: Variable<R>,
    callback: () -> R
): Variable<R> {
    return baseServerCall<R, Unit>(returnValue = returnValue, callback = callback as (Unit) -> R)!!
}

/**
 * Used to execute code on the server, using the value of the provided variable.
 * This call is synchronous so the call-site will block until the server responds.
 * @param callback the code to be executed on the server.
 * @param parameter the variable to be sent to the server,
 * the value sent will be the value of the variable at the time of the call.
 */
inline fun <reified T> JavaScript.serverCall(
    parameter: Variable<T>,
    crossinline callback: (T) -> Unit
) {
    baseServerCall<Unit, T>(parameter = parameter, callback = callback)
}

/**
 * Used to execute code on the server, with a parameter and returning a value.
 * This call is synchronous so the call-site will block until the server responds.
 * @param callback the code to be executed on the server.
 * @param parameter the variable to be sent to the server,
 * the value sent will be the value of the variable at the time of the call.
 * @return the return value of the server call.
 */
inline fun <R, reified T> JavaScript.serverCall(
    returnValue: Variable<R>,
    parameter: Variable<T>,
    crossinline callback: (T) -> R
): Variable<R> {
    return baseServerCall<R, T>(returnValue = returnValue, parameter = parameter, callback = callback)!!
}
