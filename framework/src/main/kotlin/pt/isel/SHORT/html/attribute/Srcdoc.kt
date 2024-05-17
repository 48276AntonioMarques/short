    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML srcdoc attribute.
 * Description: 
 * Supported elements: <iframe>
 */
    fun Attribute.Companion.srcdoc(value: String) = add("srcdoc", value)
    
/**
 * Represents the HTML srcdoc attribute.
 * Description: 
 * Supported elements: <iframe>
 */
    fun List<Attribute>.srcdoc(value: String) = add("srcdoc", value)
    