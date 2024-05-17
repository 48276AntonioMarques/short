    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML accept attribute.
 * Description: List of types the server accepts, typically a file type.
 * Supported elements: <form>, <input>
 */
    fun Attribute.Companion.accept(value: String) = add("accept", value)
    
/**
 * Represents the HTML accept attribute.
 * Description: List of types the server accepts, typically a file type.
 * Supported elements: <form>, <input>
 */
    fun List<Attribute>.accept(value: String) = add("accept", value)
    