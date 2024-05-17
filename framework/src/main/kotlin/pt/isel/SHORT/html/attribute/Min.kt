    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML min attribute.
 * Description: Indicates the minimum value allowed.
 * Supported elements: < input, meter >
 */
    fun Attribute.Companion.min(value: String) = add("min", value)
    
/**
 * Represents the HTML min attribute.
 * Description: Indicates the minimum value allowed.
 * Supported elements: < input, meter >
 */
    fun List<Attribute>.min(value: String) = add("min", value)
    