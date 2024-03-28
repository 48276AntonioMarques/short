package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlTag

typealias HtmlReceiver = HtmlTag.() -> Unit

fun prototype(
    tag: String,
    attributes: List<Attribute> = emptyList(),
    content: HtmlReceiver? = null
) = HtmlTag(tag, attributes, emptyList()).also { t ->
    if (content != null) {
        t.apply(content)
    }
}
