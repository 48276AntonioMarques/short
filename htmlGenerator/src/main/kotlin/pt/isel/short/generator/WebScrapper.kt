package pt.isel.short.generator

fun getTags(tag: String, html: String): List<String> {
    val tags = html.split("<$tag").map { element ->
        "<$tag" + element.substring(0, element.indexOf("</$tag>") + "</$tag>".length)
    }
    return if (tags.isEmpty()) emptyList() else tags.subList(1, tags.size)
}

fun getTables(html: String): List<String> = getTags("table", html)

fun getTableRows(tables: List<String>): List<Pair<String, String>> {
    return tables.flatMap { table ->
        val tableHead = getTags("thead", table)
        if (tableHead.size != 1) return@flatMap emptyList()
        val headRow = getTags("tr", tableHead[0])
        if (headRow.size != 1) return@flatMap emptyList()
        val head = getTags("th", headRow[0])
        if (head.size != 2 || head[0] == "Element" || head[1] == "Description") return@flatMap emptyList()

        val tableBody = getTags("tbody", table)
        if (tableBody.size != 1) return@flatMap emptyList()

        val rows = getTags("tr", tableBody[0])

        rows.flatMap { row ->
            val columns = getTags("td", row)
            if (columns.size != 2) {
                emptyList()
            } else {
                val links = getTags("a", columns[0])
                links.mapNotNull { link ->
                    val code = getTags("code", link)
                    if (code.size != 1) return@mapNotNull null
                    val codeContent = code[0]
                        .replace(Regex("<[^>]*>"), "")
                        .replace(Regex("&[^;]*;"), "")
                    val descriptionContent = columns[1]
                        .replace(Regex("<[^>]*>"), "")
                        .replace(Regex("&[^;]*;"), "")
                    Pair(codeContent, descriptionContent)
                }
            }
        }
    }
}
