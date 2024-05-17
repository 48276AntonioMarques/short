    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML cite attribute.
 * Description: Contains a URI which points to the source of the quote or change.
 * Supported elements: < blockquote, del>, <ins, q >
 */
    fun Attribute.Companion.cite(value: String) = add("cite", value)
    
/**
 * Represents the HTML cite attribute.
 * Description: Contains a URI which points to the source of the quote or change.
 * Supported elements: < blockquote, del>, <ins, q >
 */
    fun List<Attribute>.cite(value: String) = add("cite", value)
    