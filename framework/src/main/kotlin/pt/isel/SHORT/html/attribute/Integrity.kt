    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML integrity attribute.
 * Description: Specifies a Subresource Integrity value that allows browsers to verify what they fetch.
 * Supported elements: <link>, <script>
 */
    fun Attribute.Companion.integrity(value: String) = add("integrity", value)
    
/**
 * Represents the HTML integrity attribute.
 * Description: Specifies a Subresource Integrity value that allows browsers to verify what they fetch.
 * Supported elements: <link>, <script>
 */
    fun List<Attribute>.integrity(value: String) = add("integrity", value)
    