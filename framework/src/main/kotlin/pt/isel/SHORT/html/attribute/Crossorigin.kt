    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML crossorigin attribute.
 * Description: How the element handles cross-origin requests
 * Supported elements: < audio>, <img, link>, <script, video >
 */
    fun Attribute.Companion.crossorigin(value: String) = add("crossorigin", value)
    
/**
 * Represents the HTML crossorigin attribute.
 * Description: How the element handles cross-origin requests
 * Supported elements: < audio>, <img, link>, <script, video >
 */
    fun List<Attribute>.crossorigin(value: String) = add("crossorigin", value)
    