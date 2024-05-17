    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML spellcheck attribute.
 * Description: Indicates whether spell checking is allowed for the element.
 * Supported elements: <Global attribute>
 */
    fun Attribute.Companion.spellcheck(value: String) = add("spellcheck", value)
    
/**
 * Represents the HTML spellcheck attribute.
 * Description: Indicates whether spell checking is allowed for the element.
 * Supported elements: <Global attribute>
 */
    fun List<Attribute>.spellcheck(value: String) = add("spellcheck", value)
    