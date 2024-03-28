package pt.isel.SHORT.html

class Attribute(val name: String, val value: String) {

    companion object {
        fun add(name: String, value: String) = listOf(Attribute(name, value))
    }
}

fun List<Attribute>.add(name: String, value: String) = this + Attribute(name, value)
