    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML span attribute.
 * Description: 
 * Supported elements: < col, colgroup >
 */
    fun Attribute.Companion.span(value: String) = add("span", value)
    
/**
 * Represents the HTML span attribute.
 * Description: 
 * Supported elements: < col, colgroup >
 */
    fun List<Attribute>.span(value: String) = add("span", value)
    