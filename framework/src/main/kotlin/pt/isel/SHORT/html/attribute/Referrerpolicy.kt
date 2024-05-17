package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML referrerpolicy attribute.
 * Description: Specifies which referrer is sent when fetching the resource..
 * Supported elements: < a>, <area, iframe>, <img, link>, <script >
 */
fun Attribute.Companion.referrerpolicy(value: String) = add("referrerpolicy", value)

/**
 * Represents the HTML referrerpolicy attribute.
 * Description: Specifies which referrer is sent when fetching the resource..
 * Supported elements: < a>, <area, iframe>, <img, link>, <script >
 */
fun List<Attribute>.referrerpolicy(value: String) = add("referrerpolicy", value)
