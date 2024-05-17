    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML autoplay attribute.
 * Description: The audio or video should play as soon as possible.
 * Supported elements: < audio, video >
 */
    fun Attribute.Companion.autoplay(value: String) = add("autoplay", value)
    
/**
 * Represents the HTML autoplay attribute.
 * Description: The audio or video should play as soon as possible.
 * Supported elements: < audio, video >
 */
    fun List<Attribute>.autoplay(value: String) = add("autoplay", value)
    