    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML minlength attribute.
 * Description: Defines the minimum number of characters allowed in the element.
 * Supported elements: < input, textarea >
 */
    fun Attribute.Companion.minlength(value: String) = add("minlength", value)
    
/**
 * Represents the HTML minlength attribute.
 * Description: Defines the minimum number of characters allowed in the element.
 * Supported elements: < input, textarea >
 */
    fun List<Attribute>.minlength(value: String) = add("minlength", value)
    