package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML background attribute.
 * Description: Specifies the URL of an image file. Note: Although browsers and email clients may still support this attribute, it is obsolete. Use CSS background-image instead..
 * Supported elements: < body>, <table, td>, <th >
 */
fun Attribute.Companion.background(value: String) = add("background", value)

/**
 * Represents the HTML background attribute.
 * Description: Specifies the URL of an image file. Note: Although browsers and email clients may still support this attribute, it is obsolete. Use CSS background-image instead..
 * Supported elements: < body>, <table, td>, <th >
 */
fun List<Attribute>.background(value: String) = add("background", value)
