    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML form attribute.
 * Description: Indicates the form that is the owner of the element.
 * Supported elements: < button, fieldset, input, label, meter, object, output, progress, select, textarea >
 */
    fun Attribute.Companion.form(value: String) = add("form", value)
    
/**
 * Represents the HTML form attribute.
 * Description: Indicates the form that is the owner of the element.
 * Supported elements: < button, fieldset, input, label, meter, object, output, progress, select, textarea >
 */
    fun List<Attribute>.form(value: String) = add("form", value)
    