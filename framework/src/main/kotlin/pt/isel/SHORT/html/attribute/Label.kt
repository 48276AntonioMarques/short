    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML label attribute.
 * Description: Specifies a user-readable title of the element.
 * Supported elements: < optgroup, option, track >
 */
    fun Attribute.Companion.label(value: String) = add("label", value)
    
/**
 * Represents the HTML label attribute.
 * Description: Specifies a user-readable title of the element.
 * Supported elements: < optgroup, option, track >
 */
    fun List<Attribute>.label(value: String) = add("label", value)
    