    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML csp attribute.
 * Description: Specifies the Content Security Policy that an embedded document must agree to enforce upon itself.
 * Supported elements: <iframe>
 */
    fun Attribute.Companion.csp(value: String) = add("csp", value)
    
/**
 * Represents the HTML csp attribute.
 * Description: Specifies the Content Security Policy that an embedded document must agree to enforce upon itself.
 * Supported elements: <iframe>
 */
    fun List<Attribute>.csp(value: String) = add("csp", value)
    