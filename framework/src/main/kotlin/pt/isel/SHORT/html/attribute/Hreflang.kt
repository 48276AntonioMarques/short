    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML hreflang attribute.
 * Description: Specifies the language of the linked resource.
 * Supported elements: <a>, <link>
 */
    fun Attribute.Companion.hreflang(value: String) = add("hreflang", value)
    
/**
 * Represents the HTML hreflang attribute.
 * Description: Specifies the language of the linked resource.
 * Supported elements: <a>, <link>
 */
    fun List<Attribute>.hreflang(value: String) = add("hreflang", value)
    