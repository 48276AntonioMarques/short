package pt.isel.SHORT.html.base.element

import pt.isel.SHORT.component.Component
import pt.isel.SHORT.html.attribute.id
import pt.isel.SHORT.html.base.attribute.Attribute

typealias HtmlReceiver = Tag.(HtmlScope) -> Unit

fun prototype(
    tag: String,
    attributes: List<Attribute> = emptyList(),
    scope: HtmlScope,
    content: HtmlReceiver? = null
): Tag {
    val node = Tag(tag, attributes, scope, emptyList())
    if (content != null) {
        // This cast is safe but not checked by the compiler because the type is erased
        val contentFunction = content.javaClass
        val components = contentFunction.annotations.filterIsInstance<Component>()
        val isComponent = components.isNotEmpty()

        if (components.size > 1) {
            throw IllegalArgumentException("Component annotation can only be used once per function")
        }

        // Only run content if it is not a component
        // Or if legacy mode is enabled
        // TODO: Verify if client is legacy
        if (isComponent) {
            return Tag("component", Attribute.id("component-${contentFunction.name}"), scope, emptyList())
        } else {
            node.content(scope)
        }
    }
    return node
}
