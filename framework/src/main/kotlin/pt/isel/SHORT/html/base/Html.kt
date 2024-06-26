package pt.isel.SHORT.html.base

import pt.isel.SHORT.html.base.element.Element
import pt.isel.SHORT.html.base.element.HtmlReceiver
import pt.isel.SHORT.html.base.element.HtmlScope
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.base.element.loadHtmlContent

class Html : Element {
    val scope = HtmlScope(this)

    val tag = Tag("html", emptyList(), scope, emptyList())
    val head = Tag("head", emptyList(), scope, emptyList())
    val body = Tag("body", emptyList(), scope, emptyList())

    init {
        tag.appendChild(head)
        tag.appendChild(body)
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

fun Html.Head(content: HtmlReceiver? = null): Tag {
    return this.head.apply {
        if (content != null) {
            loadHtmlContent(content)
        }
    }
}

fun Html.Body(content: HtmlReceiver? = null): Tag {
    return this.body.apply {
        if (content != null) {
            loadHtmlContent(content)
        }
    }
}
