package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML formnovalidate attribute.
 * Description:  If the button/input is a submit button (e.g. type="submit"), this boolean attribute specifies that the form is not to be validated when it is submitted. If this attribute is specified, it overrides the novalidate attribute of the button's form owner. 
 * Supported elements: < button, input >
 */
fun Attribute.Companion.formnovalidate(value: String) = add("formnovalidate", value)
fun List<Attribute>.formnovalidate(value: String) = add("formnovalidate", value)