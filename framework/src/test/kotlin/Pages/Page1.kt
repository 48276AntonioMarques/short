package Pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.Text
import pt.isel.SHORT.html.element.Div

@Page("/")
fun Tag.page1() = Div { Text("Hello from Page 1.") }
