package pt.isel.SHORT.html.base.element

import pt.isel.SHORT.JavaScriptException
import pt.isel.SHORT.client.JsScope
import pt.isel.SHORT.component.Variable
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.EventAttribute

open class Tag(
    internal val tag: String,
    internal val attributes: List<Attribute>,
    val scope: HtmlScope,
    children: List<Element>
) : Element {
    private val children = children.toMutableList()

    init {
        attributes.forEach { attribute ->
            if (attribute is EventAttribute) {
                if (tag == "input") {
                    println("Event attribute in input")
                }
                attribute.register(scope)
            }
        }
    }

    // This function exists in JS
    // Ensure that the HTML generator does not try to recreate the same function
    fun appendChild(child: Element): Element {
        children += child
        return this
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
                JsScope(scope.globalScript) {
                    console.log("Error while generating attribute: ${jse.message}")
                }
                null
            }
        }

        return try {
            val attributesString = if (attr.isNotEmpty()) " ${attr.joinToString(" ")}" else ""
            "<$tag$attributesString>${innerHtml()}</$tag>"
        } catch (jse: JavaScriptException) {
            JsScope(scope.globalScript) {
                console.log("Error while generating tag: ${jse.message}")
            }
            ""
        }
    }

    // This function exists in JS
    // Ensure that the HTML generator does not try to recreate the same function
    override fun innerHtml() = children.joinToString("") { child -> child.toHtml() }
}
