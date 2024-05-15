package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML enterkeyhint attribute.
 * Description:  The enterkeyhint specifies what action label (or icon) to present for the enter key on virtual keyboards. The attribute can be used with form controls (such as the value of textarea elements), or in elements in an editing host (e.g., using contenteditable attribute). 
 * Supported elements: < textarea, contenteditable >
 */
fun Attribute.Companion.enterkeyhint(value: String) = add("enterkeyhint", value)
fun List<Attribute>.enterkeyhint(value: String) = add("enterkeyhint", value)