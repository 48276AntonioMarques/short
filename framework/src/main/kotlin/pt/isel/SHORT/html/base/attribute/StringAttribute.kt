package pt.isel.SHORT.html.base.attribute

class StringAttribute(override val name: String, override val value: String) : Attribute {
    override fun toHtml() = "$name=\"$value\""
}

fun Attribute.Companion.add(name: String, value: String) = listOf<Attribute>(StringAttribute(name, value))
fun List<Attribute>.add(name: String, value: String) = this + StringAttribute(name, value)
