package PageAggregatorSources

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Text

@Page("/")
fun HtmlTag.page1() = Div { Text("Hello World") }
