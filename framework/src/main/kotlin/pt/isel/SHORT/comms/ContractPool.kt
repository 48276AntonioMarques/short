package pt.isel.SHORT.comms

class ContractPool(
    private val add: (contract: Contract) -> ContractID,
    private val get: (contractID: ContractID) -> Contract
) {
    fun add(contract: Contract): ContractID = this.add.invoke(contract)
    operator fun get(contractID: ContractID): Contract = this.get.invoke(contractID)
}
