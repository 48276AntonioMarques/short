    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML low attribute.
 * Description: Indicates the upper bound of the lower range.
 * Supported elements: <meter>
 */
    fun Attribute.Companion.low(value: String) = add("low", value)
    
/**
 * Represents the HTML low attribute.
 * Description: Indicates the upper bound of the lower range.
 * Supported elements: <meter>
 */
    fun List<Attribute>.low(value: String) = add("low", value)
    