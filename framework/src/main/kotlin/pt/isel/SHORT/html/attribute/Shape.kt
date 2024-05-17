    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML shape attribute.
 * Description: 
 * Supported elements: <a>, <area>
 */
    fun Attribute.Companion.shape(value: String) = add("shape", value)
    
/**
 * Represents the HTML shape attribute.
 * Description: 
 * Supported elements: <a>, <area>
 */
    fun List<Attribute>.shape(value: String) = add("shape", value)
    