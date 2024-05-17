    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML intrinsicsize attribute.
 * Description: This attribute tells the browser to ignore the actual intrinsic size of the image and pretend it's the size specified in the attribute.
 * Supported elements: <img>
 */
    fun Attribute.Companion.intrinsicsize(value: String) = add("intrinsicsize", value)
    
/**
 * Represents the HTML intrinsicsize attribute.
 * Description: This attribute tells the browser to ignore the actual intrinsic size of the image and pretend it's the size specified in the attribute.
 * Supported elements: <img>
 */
    fun List<Attribute>.intrinsicsize(value: String) = add("intrinsicsize", value)
    