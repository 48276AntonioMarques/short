    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML multiple attribute.
 * Description: Indicates whether multiple values can be entered in an input of the type email or file.
 * Supported elements: < input, select >
 */
    fun Attribute.Companion.multiple(value: String) = add("multiple", value)
    
/**
 * Represents the HTML multiple attribute.
 * Description: Indicates whether multiple values can be entered in an input of the type email or file.
 * Supported elements: < input, select >
 */
    fun List<Attribute>.multiple(value: String) = add("multiple", value)
    