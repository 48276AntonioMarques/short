package Pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div

@Page("/")
fun Tag.page1() = Div { Text("Hello from Page 1.") }
