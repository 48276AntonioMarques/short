package pt.isel.SHORT.html

import pt.isel.SHORT.AggregationMode

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
