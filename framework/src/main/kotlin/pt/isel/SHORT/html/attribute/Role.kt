    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML role attribute.
 * Description: Defines an explicit role for an element for use by assistive technologies.
 * Supported elements: <Global attribute>
 */
    fun Attribute.Companion.role(value: String) = add("role", value)
    
/**
 * Represents the HTML role attribute.
 * Description: Defines an explicit role for an element for use by assistive technologies.
 * Supported elements: <Global attribute>
 */
    fun List<Attribute>.role(value: String) = add("role", value)
    