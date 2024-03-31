package pt.isel.SHORT.html

import pt.isel.SHORT.JavaScriptException
import pt.isel.SHORT.component.Variable

open class Tag(
    internal val tag: String,
    internal val attributes: List<Attribute>,
    children: List<Element>
) : Element {
    private val children = children.toMutableList()

    private val _variables = mutableListOf<Variable<Any>>()

    // This function exists in JS
    // Ensure that the HTML generator does not try to recreate the same function
    fun appendChild(child: Element): Element {
        children += child
        return this
    }

    fun appendVariable(variable: Variable<Any>) {
        _variables += variable
    }

    /** Function to convert a tag to HTML in the format:
     * <[tag] [attributes]>[innerHtml]</[tag]>
     *  @param tag the tag of the element
     *  @param attributes the list containing the attributes of the element
     *  @param innerHtml the inner HTML of the element
     */
    override fun toHtml(): String {
        val attr = attributes.mapNotNull { attribute ->
            try {
                attribute.toHtml()
            } catch (jse: JavaScriptException) {
                println(jse.message)
                // TODO: Log error on client
                null
            }
        }
        return try {
            if (attr.isEmpty()) {
                "<$tag>${innerHtml()}</$tag>"
            } else {
                "<$tag ${attr.joinToString(" ")}>${innerHtml()}</$tag>"
            }
        } catch (jse: JavaScriptException) {
            println(jse.message)
            // TODO: Log error on client
            println("Error in tag: $tag")
            ""
        }
    }

    // This function exists in JS
    // Ensure that the HTML generator does not try to recreate the same function
    fun innerHtml() = children.joinToString("") { child -> child.toHtml() }
}
