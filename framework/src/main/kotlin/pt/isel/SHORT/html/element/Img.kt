package pt.isel.SHORT.html.element

import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.src
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
fun embedImg(src: String): String {
    val resource = getResource(name = src)?.readBytes()
    if (resource == null) {
        println("Resource not found: $src")
        return ""
    } else {
        val base64 = Base64.encode(resource, 0, resource.size)
        val extension = src.substringAfterLast('.')
        return "data:image/$extension;base64,$base64"
    }
}

fun HtmlTag.Img(src: String, embed: Boolean) = apply {
    val srcOption = if (embed) embedImg(src) else src
    appendChild(
        prototype("img", attributes = Attribute.src(srcOption))
    )
}
