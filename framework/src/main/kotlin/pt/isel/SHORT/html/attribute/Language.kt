    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML language attribute.
 * Description: Defines the script language used in the element.
 * Supported elements: <script>
 */
    fun Attribute.Companion.language(value: String) = add("language", value)
    
/**
 * Represents the HTML language attribute.
 * Description: Defines the script language used in the element.
 * Supported elements: <script>
 */
    fun List<Attribute>.language(value: String) = add("language", value)
    