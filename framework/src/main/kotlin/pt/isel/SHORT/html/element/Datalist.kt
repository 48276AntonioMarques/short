package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.HtmlReceiver
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.prototype

/**
 * Represents the HTML <datalist> tag.
 * Description: Contains a set of option elements that represent the permissible or recommended options available to choose from within other controls.
 */
fun Tag.Datalist(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("datalist", attributes, content))
}
