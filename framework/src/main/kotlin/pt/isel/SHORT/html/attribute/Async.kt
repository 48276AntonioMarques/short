    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML async attribute.
 * Description: Executes the script asynchronously.
 * Supported elements: <script>
 */
    fun Attribute.Companion.async(value: String) = add("async", value)
    
/**
 * Represents the HTML async attribute.
 * Description: Executes the script asynchronously.
 * Supported elements: <script>
 */
    fun List<Attribute>.async(value: String) = add("async", value)
    