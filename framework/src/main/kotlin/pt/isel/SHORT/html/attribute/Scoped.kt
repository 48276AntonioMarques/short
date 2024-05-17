    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML scoped attribute.
 * Description: 
 * Supported elements: <style>
 */
    fun Attribute.Companion.scoped(value: String) = add("scoped", value)
    
/**
 * Represents the HTML scoped attribute.
 * Description: 
 * Supported elements: <style>
 */
    fun List<Attribute>.scoped(value: String) = add("scoped", value)
    