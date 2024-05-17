    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML cols attribute.
 * Description: Defines the number of columns in a textarea.
 * Supported elements: <textarea>
 */
    fun Attribute.Companion.cols(value: String) = add("cols", value)
    
/**
 * Represents the HTML cols attribute.
 * Description: Defines the number of columns in a textarea.
 * Supported elements: <textarea>
 */
    fun List<Attribute>.cols(value: String) = add("cols", value)
    