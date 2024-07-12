package pt.isel.SHORT.comms

import org.http4k.core.Request
import org.http4k.core.Response

/**
 * Function used to execute all the contracts registered in the ContractRegistry.
 * Every serverCall function register will be executed inside this function.
 */
fun executeContract(request: Request, contractID: ContractID): Response {
    val index: Int = contractID
    val contract = ContractRegistry.contracts[index]
    try {
        return contract.invoke(request)
    } catch (e: Exception) {
        throw RuntimeException("Error executing contract with id $contractID", e)
    }
}
