package PageAggregatorSources

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.Text
import pt.isel.SHORT.html.element.single.Div

@Page("/page2")
fun page2() = Div { Text("Hello World") }

@Page("/page3")
fun page3() = Div { Text("Hello Again") }
