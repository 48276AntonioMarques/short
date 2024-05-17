    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML scope attribute.
 * Description: Defines the cells that the header test (defined in the th element) relates to.
 * Supported elements: <th>
 */
    fun Attribute.Companion.scope(value: String) = add("scope", value)
    
/**
 * Represents the HTML scope attribute.
 * Description: Defines the cells that the header test (defined in the th element) relates to.
 * Supported elements: <th>
 */
    fun List<Attribute>.scope(value: String) = add("scope", value)
    