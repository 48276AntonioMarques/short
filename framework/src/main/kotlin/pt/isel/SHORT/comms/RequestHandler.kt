package pt.isel.SHORT.comms

import org.http4k.core.Request
import org.http4k.core.Response

fun executeContract(request: Request, contractID: ContractID): Response {
    val index: Int = contractID
    val response = ContractRegistry.contracts[index].invoke(request)
    return response
}
