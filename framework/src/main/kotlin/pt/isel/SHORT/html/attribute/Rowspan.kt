    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML rowspan attribute.
 * Description: Defines the number of rows a table cell should span over.
 * Supported elements: <td>, <th>
 */
    fun Attribute.Companion.rowspan(value: String) = add("rowspan", value)
    
/**
 * Represents the HTML rowspan attribute.
 * Description: Defines the number of rows a table cell should span over.
 * Supported elements: <td>, <th>
 */
    fun List<Attribute>.rowspan(value: String) = add("rowspan", value)
    