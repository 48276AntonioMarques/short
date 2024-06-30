package pt.isel.SHORT.html.base.element

import pt.isel.SHORT.client.EventHandler
import pt.isel.SHORT.client.EventScope
import pt.isel.SHORT.client.JavaScript
import pt.isel.SHORT.client.Variable
import pt.isel.SHORT.comms.Contract
import pt.isel.SHORT.comms.ContractID
import pt.isel.SHORT.comms.ContractPool
import pt.isel.SHORT.html.base.Html

class HtmlScope(val html: Html) {
    private val eventHandlers: MutableMap<String, EventHandler> = mutableMapOf()
    private val variables: MutableMap<String, Variable<*>> = mutableMapOf()
    private val contracts: MutableList<Contract> = mutableListOf()
    val contractPool = ContractPool(::registerContract, contracts::get)

    val globalScript: JavaScript by lazy { JavaScript(html.tag, contractPool) }

    private fun <T> generateID(map: MutableMap<String, T>): String {
        val validChars = ('0'..'9') + ('A'..'Z') + ('a'..'z')
        var id = ""
        do {
            // Generate a random ID
            id = (1..10).map { validChars.random() }.joinToString("")
        } while (map.any { entry -> entry.key == id })
        return id
    }

    private fun <T> addValue(map: MutableMap<String, T>, prefix: String, value: T): String {
        val id = "$prefix${generateID(map)}"
        map[id] = value
        return id
    }

    fun registerHandler(eventHandler: EventHandler) = addValue(eventHandlers, "eH", eventHandler)

    fun eventHandlersToHtml(): String {
        return eventHandlers.entries.joinToString("") { (id, handler) ->
            val eventScope = EventScope(contractPool, html.tag)
            eventScope.handler()
            val eventHtml = eventScope.toHtml()
            "async function $id(event) {$eventHtml};"
        }
    }

    fun variablesToHtml(): String {
        return "const _SHORT_VARIABLES_ = {" + variables.entries.joinToString(",") { (id, variable) ->
            "'$id': ${variable.defaultValue}"
        } + "};"
    }

    fun <T> newVariable(value: T): Variable<T> {
        val id = "var" + generateID(variables)
        val variable = Variable(id, value)
        variables[id] = variable
        return variable
    }

    private fun registerContract(contract: Contract): ContractID {
        if (!contracts.contains(contract)) {
            contracts.add(contract)
            return contracts.size - 1
        }
        return contracts.indexOf(contract)
    }

    fun contractsToHtml(): String {
        return "const _SHORT_CONTRACTS_ = {" + contracts.mapIndexed { index, contract ->
            "'$index': {${contract.toHtml(index)}}"
        }.joinToString(",") + "};"
    }
}
