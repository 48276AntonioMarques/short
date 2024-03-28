package PageAggregatorSources

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.Text
import pt.isel.SHORT.html.element.single.Div

@Page("/")
fun page1() = Div { Text("Hello World") }
