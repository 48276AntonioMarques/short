    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML accept-charset attribute.
 * Description: List of supported charsets.
 * Supported elements: <form>
 */
    fun Attribute.Companion.acceptCharset(value: String) = add("accept-charset", value)
    
/**
 * Represents the HTML accept-charset attribute.
 * Description: List of supported charsets.
 * Supported elements: <form>
 */
    fun List<Attribute>.acceptCharset(value: String) = add("accept-charset", value)
    