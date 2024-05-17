    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML max attribute.
 * Description: Indicates the maximum value allowed.
 * Supported elements: < input, meter, progress >
 */
    fun Attribute.Companion.max(value: String) = add("max", value)
    
/**
 * Represents the HTML max attribute.
 * Description: Indicates the maximum value allowed.
 * Supported elements: < input, meter, progress >
 */
    fun List<Attribute>.max(value: String) = add("max", value)
    