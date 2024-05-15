package pt.isel.SHORT.html.attribute

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.add

/**
 * Represents the HTML open attribute.
 * Description:  Indicates whether the contents are currently visible (in the case of a details element) or whether the dialog is active and can be interacted with (in the case of a dialog element). 
 * Supported elements: < details, dialog >
 */
fun Attribute.Companion.open(value: String) = add("open", value)
fun List<Attribute>.open(value: String) = add("open", value)