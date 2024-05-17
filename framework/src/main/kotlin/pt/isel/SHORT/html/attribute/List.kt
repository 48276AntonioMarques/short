    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML list attribute.
 * Description: Identifies a list of pre-defined options to suggest to the user.
 * Supported elements: <input>
 */
    fun Attribute.Companion.list(value: String) = add("list", value)
    
/**
 * Represents the HTML list attribute.
 * Description: Identifies a list of pre-defined options to suggest to the user.
 * Supported elements: <input>
 */
    fun List<Attribute>.list(value: String) = add("list", value)
    