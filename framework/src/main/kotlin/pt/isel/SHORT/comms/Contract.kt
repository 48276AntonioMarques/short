package pt.isel.SHORT.comms

typealias ContractID = Int

class Contract(
    private val callback: Any
) {
    private val version: Byte = 0x01

    fun toHtml(id: ContractID): String {
        // Calculate the length of the contract
        val length = 0
        return "SOME_HTML"
    }
}
