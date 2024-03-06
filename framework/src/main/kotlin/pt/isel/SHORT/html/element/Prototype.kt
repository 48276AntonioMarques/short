package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.HtmlTag

typealias HtmlReceiver = HtmlTag.() -> Unit

fun prototype(tag: String, content: HtmlReceiver? = null) =
    HtmlTag(tag, emptyList()).also { t ->
        if (content != null) {
            t.apply(content)
        }
    }
