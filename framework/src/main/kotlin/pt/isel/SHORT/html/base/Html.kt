package pt.isel.SHORT.html.base

import pt.isel.SHORT.AggregationMode
import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.element.Element
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.prototype

class Html : Element {
    var tag = Tag("html", emptyList(), emptyList())
        private set
    var aggregationMode: AggregationMode = AggregationMode.TEMPLATE
        private set

    fun using(aggregationMode: AggregationMode): Html {
        val newHtml = Html()
        newHtml.tag = tag
        newHtml.aggregationMode = aggregationMode
        return newHtml
    }

    override fun toHtml(): String {
        return tag.toHtml()
    }

    override fun innerHtml(): String {
        return tag.innerHtml()
    }
}

fun Html(content: Html.() -> Unit) =
    Html().apply(content)

fun Html.Head(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = tag.apply {
    appendChild(prototype("head", attributes, content))
}

fun Html.Body(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = tag.apply {
    appendChild(prototype("body", attributes, content))
}
