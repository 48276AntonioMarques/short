    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML headers attribute.
 * Description: IDs of the th elements which applies to this element.
 * Supported elements: <td>, <th>
 */
    fun Attribute.Companion.headers(value: String) = add("headers", value)
    
/**
 * Represents the HTML headers attribute.
 * Description: IDs of the th elements which applies to this element.
 * Supported elements: <td>, <th>
 */
    fun List<Attribute>.headers(value: String) = add("headers", value)
    