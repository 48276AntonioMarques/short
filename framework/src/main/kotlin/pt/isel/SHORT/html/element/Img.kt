package pt.isel.SHORT.html.element

import io.github.oshai.kotlinlogging.KotlinLogging
import pt.isel.SHORT.ResourceNotFoundException
import pt.isel.SHORT.getResource
import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.attribute.src
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

private val logger = KotlinLogging.logger {}

/**
 *
 * throws [ResourceNotFoundException] if the image is not found
 */
@OptIn(ExperimentalEncodingApi::class)
fun embedImg(src: String): String {
    val resource = getResource(name = src).readBytes()
    val base64 = Base64.encode(resource, 0, resource.size)
    val extension = src.substringAfterLast('.')
    return "data:image/$extension;base64,$base64"
}

fun Tag.Img(src: String, embed: Boolean = false) = apply {
    var srcOption = src
    try {
        if (embed) {
            srcOption = embedImg(src)
        }
    } catch (_: ResourceNotFoundException) {
        logger.warn { "Resource not found: $src" }
    }
    appendChild(
        prototype("img", attributes = Attribute.src(srcOption))
    )
}
