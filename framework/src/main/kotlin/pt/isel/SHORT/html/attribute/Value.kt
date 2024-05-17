    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML value attribute.
 * Description: Defines a default value which will be displayed in the element on page load.
 * Supported elements: < button>, <data, input>, <li, meter, option, progress, param >
 */
    fun Attribute.Companion.`value`(value: String) = add("value", value)
    
/**
 * Represents the HTML value attribute.
 * Description: Defines a default value which will be displayed in the element on page load.
 * Supported elements: < button>, <data, input>, <li, meter, option, progress, param >
 */
    fun List<Attribute>.`value`(value: String) = add("value", value)
    