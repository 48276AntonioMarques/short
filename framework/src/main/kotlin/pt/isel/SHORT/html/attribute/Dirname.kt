    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML dirname attribute.
 * Description: 
 * Supported elements: < input, textarea >
 */
    fun Attribute.Companion.dirname(value: String) = add("dirname", value)
    
/**
 * Represents the HTML dirname attribute.
 * Description: 
 * Supported elements: < input, textarea >
 */
    fun List<Attribute>.dirname(value: String) = add("dirname", value)
    