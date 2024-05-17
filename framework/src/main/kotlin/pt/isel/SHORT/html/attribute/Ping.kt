package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML ping attribute.
 * Description: The ping attribute specifies a space-separated list of URLs to be notified if a user follows the hyperlink..
 * Supported elements: <a>, <area>
 */
fun Attribute.Companion.ping(value: String) = add("ping", value)

/**
 * Represents the HTML ping attribute.
 * Description: The ping attribute specifies a space-separated list of URLs to be notified if a user follows the hyperlink..
 * Supported elements: <a>, <area>
 */
fun List<Attribute>.ping(value: String) = add("ping", value)
