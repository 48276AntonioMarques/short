    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML kind attribute.
 * Description: Specifies the kind of text track.
 * Supported elements: <track>
 */
    fun Attribute.Companion.kind(value: String) = add("kind", value)
    
/**
 * Represents the HTML kind attribute.
 * Description: Specifies the kind of text track.
 * Supported elements: <track>
 */
    fun List<Attribute>.kind(value: String) = add("kind", value)
    