package Pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Text

@Page("/page2")
fun Tag.page2() = Div { Text("Hello from Page 2.") }
