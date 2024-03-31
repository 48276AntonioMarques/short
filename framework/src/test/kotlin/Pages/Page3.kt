package Pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.Tag
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Text

@Page("/page3")
fun Tag.page3() = Div { Text("Hello from Page 3.") }
