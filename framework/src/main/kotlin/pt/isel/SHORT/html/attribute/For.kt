    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML for attribute.
 * Description: Describes elements which belongs to this one.
 * Supported elements: < label, output >
 */
    fun Attribute.Companion.`for`(value: String) = add("for", value)
    
/**
 * Represents the HTML for attribute.
 * Description: Describes elements which belongs to this one.
 * Supported elements: < label, output >
 */
    fun List<Attribute>.`for`(value: String) = add("for", value)
    