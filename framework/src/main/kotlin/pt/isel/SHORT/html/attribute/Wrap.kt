    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML wrap attribute.
 * Description: Indicates whether the text should be wrapped.
 * Supported elements: <textarea>
 */
    fun Attribute.Companion.wrap(value: String) = add("wrap", value)
    
/**
 * Represents the HTML wrap attribute.
 * Description: Indicates whether the text should be wrapped.
 * Supported elements: <textarea>
 */
    fun List<Attribute>.wrap(value: String) = add("wrap", value)
    