package pt.isel.SHORT.html.element

import pt.isel.SHORT.component.Component
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.attribute.id

typealias HtmlReceiver = Tag.() -> Unit

fun prototype(
    tag: String,
    attributes: List<Attribute> = emptyList(),
    content: HtmlReceiver? = null
): Tag {
    val node = Tag(tag, attributes, emptyList())
    if (content != null) {
        // This cast is safe but not checked by the compiler because the type is erased
        val contentFunction = content.javaClass
        val components = contentFunction.annotations.filterIsInstance<Component>()

        if (components.size > 1) {
            throw IllegalArgumentException("Component annotation can only be used once per function")
        }

        // Only run content if it is not a component
        // Or if legacy mode is enabled
        // TODO: Verify if client is legacy
        if (components.isEmpty()) {
            node.apply(content)
        } else {
            return Tag("component", Attribute.id("component-${contentFunction.name}"), emptyList())
        }
    }
    return node
}
