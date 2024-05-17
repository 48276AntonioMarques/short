    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML muted attribute.
 * Description: Indicates whether the audio will be initially silenced on page load.
 * Supported elements: < audio, video >
 */
    fun Attribute.Companion.muted(value: String) = add("muted", value)
    
/**
 * Represents the HTML muted attribute.
 * Description: Indicates whether the audio will be initially silenced on page load.
 * Supported elements: < audio, video >
 */
    fun List<Attribute>.muted(value: String) = add("muted", value)
    