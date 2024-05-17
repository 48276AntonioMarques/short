    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML usemap attribute.
 * Description: 
 * Supported elements: < img>, <input, object >
 */
    fun Attribute.Companion.usemap(value: String) = add("usemap", value)
    
/**
 * Represents the HTML usemap attribute.
 * Description: 
 * Supported elements: < img>, <input, object >
 */
    fun List<Attribute>.usemap(value: String) = add("usemap", value)
    