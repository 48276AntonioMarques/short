package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.base.attribute.Attribute
import pt.isel.SHORT.html.base.attribute.add

/**
 * Represents the HTML formenctype attribute.
 * Description: If the button/input is a submit button (e.g. type="submit"), this attribute sets the encoding type to use during form submission. If this attribute is specified, it overrides the enctype attribute of the button's form owner..
 * Supported elements: < button, input >
 */
fun Attribute.Companion.formenctype(value: String) = add("formenctype", value)

/**
 * Represents the HTML formenctype attribute.
 * Description: If the button/input is a submit button (e.g. type="submit"), this attribute sets the encoding type to use during form submission. If this attribute is specified, it overrides the enctype attribute of the button's form owner..
 * Supported elements: < button, input >
 */
fun List<Attribute>.formenctype(value: String) = add("formenctype", value)
