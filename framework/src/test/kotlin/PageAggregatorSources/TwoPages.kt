package PageAggregatorSources

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.HtmlTag
import pt.isel.SHORT.html.element.Text
import pt.isel.SHORT.html.element.Div

@Page("/page2")
fun HtmlTag.page2() = Div { Text("Hello World") }

@Page("/page3")
fun HtmlTag.page3() = Div { Text("Hello Again") }
