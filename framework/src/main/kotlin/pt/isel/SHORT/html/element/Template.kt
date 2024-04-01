package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

fun Tag.Template(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null) = apply {
    appendChild(prototype("template", attributes, content))
}
