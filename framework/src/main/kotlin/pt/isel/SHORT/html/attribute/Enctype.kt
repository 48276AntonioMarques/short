    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML enctype attribute.
 * Description: Defines the content type of the form data when the method is POST.
 * Supported elements: <form>
 */
    fun Attribute.Companion.enctype(value: String) = add("enctype", value)
    
/**
 * Represents the HTML enctype attribute.
 * Description: Defines the content type of the form data when the method is POST.
 * Supported elements: <form>
 */
    fun List<Attribute>.enctype(value: String) = add("enctype", value)
    