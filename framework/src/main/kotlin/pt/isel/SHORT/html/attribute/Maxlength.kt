    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML maxlength attribute.
 * Description: Defines the maximum number of characters allowed in the element.
 * Supported elements: < input, textarea >
 */
    fun Attribute.Companion.maxlength(value: String) = add("maxlength", value)
    
/**
 * Represents the HTML maxlength attribute.
 * Description: Defines the maximum number of characters allowed in the element.
 * Supported elements: < input, textarea >
 */
    fun List<Attribute>.maxlength(value: String) = add("maxlength", value)
    