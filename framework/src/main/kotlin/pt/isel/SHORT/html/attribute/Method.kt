    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML method attribute.
 * Description: Defines which HTTP method to use when submitting the form. Can be GET (default) or POST.
 * Supported elements: <form>
 */
    fun Attribute.Companion.method(value: String) = add("method", value)
    
/**
 * Represents the HTML method attribute.
 * Description: Defines which HTTP method to use when submitting the form. Can be GET (default) or POST.
 * Supported elements: <form>
 */
    fun List<Attribute>.method(value: String) = add("method", value)
    