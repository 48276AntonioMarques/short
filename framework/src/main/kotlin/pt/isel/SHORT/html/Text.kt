package pt.isel.SHORT.html

class Text(val content: () -> String) : Element {
    override fun toHtml(): String = content()
}
