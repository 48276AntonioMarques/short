package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

typealias HtmlReceiver = Tag.() -> Unit

fun prototype(
    tag: String,
    attributes: List<Attribute> = emptyList(),
    content: HtmlReceiver? = null
) = Tag(tag, attributes, emptyList()).also { t ->
    if (content != null) {
        t.apply(content)
    }
}
