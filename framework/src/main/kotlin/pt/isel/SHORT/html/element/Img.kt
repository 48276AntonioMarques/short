package pt.isel.SHORT.html.element

import io.github.oshai.kotlinlogging.KotlinLogging
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

private val logger = KotlinLogging.logger {}

fun Tag.Img(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("img", attributes, content))
}
