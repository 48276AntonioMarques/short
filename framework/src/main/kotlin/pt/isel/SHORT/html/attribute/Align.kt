    package pt.isel.SHORT.html.attribute
    
    import pt.isel.SHORT.html.base.attribute.Attribute
    import pt.isel.SHORT.html.base.attribute.add
    
/**
 * Represents the HTML align attribute.
 * Description: Specifies the horizontal alignment of the element.
 * Supported elements: < caption>, <col, colgroup, hr>, <iframe, img>, <table, tbody>, <td, tfoot>, <th, thead>, <tr >
 */
    fun Attribute.Companion.align(value: String) = add("align", value)
    
/**
 * Represents the HTML align attribute.
 * Description: Specifies the horizontal alignment of the element.
 * Supported elements: < caption>, <col, colgroup, hr>, <iframe, img>, <table, tbody>, <td, tfoot>, <th, thead>, <tr >
 */
    fun List<Attribute>.align(value: String) = add("align", value)
    