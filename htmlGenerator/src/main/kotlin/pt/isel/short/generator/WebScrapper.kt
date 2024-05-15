package pt.isel.short.generator

fun getTags(tag: String, html: String): List<String> {
    val tags = html.split(Regex("<$tag>|<$tag >|<$tag (.+?)>")).mapNotNull { element ->
        if (element.indexOf("</$tag>") == -1) return@mapNotNull null
        "<$tag>" + element.substring(0, element.indexOf("</$tag>") + "</$tag>".length)
    }
    return tags
}

fun getTables(html: String): List<String> = getTags("table", html)

fun clearScripts(html: String): String {
    return html.replace(Regex("<script[^>]*>[\\s\\S]*?</script>"), "")
}
