    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML draggable attribute.
 * Description: Defines whether the element can be dragged.
 * Supported elements: <Global attribute>
 */
    fun Attribute.Companion.draggable(value: String) = add("draggable", value)
    
/**
 * Represents the HTML draggable attribute.
 * Description: Defines whether the element can be dragged.
 * Supported elements: <Global attribute>
 */
    fun List<Attribute>.draggable(value: String) = add("draggable", value)
    