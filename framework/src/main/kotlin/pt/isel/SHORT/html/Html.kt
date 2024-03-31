package pt.isel.SHORT.html

class Html(
    tag: String,
    attributes: List<Attribute>,
    children: List<Element>
) : Tag(tag, attributes, children)

fun Html(content: Html.() -> Unit) =
    Html("html", emptyList(), emptyList()).apply(content)
