    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML lang attribute.
 * Description: Defines the language used in the element.
 * Supported elements: <Global attribute>
 */
    fun Attribute.Companion.lang(value: String) = add("lang", value)
    
/**
 * Represents the HTML lang attribute.
 * Description: Defines the language used in the element.
 * Supported elements: <Global attribute>
 */
    fun List<Attribute>.lang(value: String) = add("lang", value)
    