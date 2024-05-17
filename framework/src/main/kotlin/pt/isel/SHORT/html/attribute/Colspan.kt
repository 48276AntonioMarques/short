    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML colspan attribute.
 * Description: The colspan attribute defines the number of columns a cell should span.
 * Supported elements: <td>, <th>
 */
    fun Attribute.Companion.colspan(value: String) = add("colspan", value)
    
/**
 * Represents the HTML colspan attribute.
 * Description: The colspan attribute defines the number of columns a cell should span.
 * Supported elements: <td>, <th>
 */
    fun List<Attribute>.colspan(value: String) = add("colspan", value)
    