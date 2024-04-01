package pt.isel.SHORT.html

import pt.isel.SHORT.AggregationMode

class Html(
    tag: String,
    attributes: List<Attribute>,
    children: List<Element>
) : Element {
    val tag = Tag(tag, attributes, children)
    var aggregation = AggregationMode.LEGACY

    fun enableLegacyAggregation() {
        aggregation = AggregationMode.LEGACY
    }

    override fun toHtml(): String {
        return tag.toHtml()
    }

    override fun innerHtml(): String {
        return tag.innerHtml()
    }
}

fun Html(content: Html.() -> Unit) =
    Html("html", emptyList(), emptyList()).apply(content)
