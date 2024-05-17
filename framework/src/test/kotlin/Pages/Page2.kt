package Pages

import pt.isel.SHORT.Page
import pt.isel.SHORT.html.base.Text
import pt.isel.SHORT.html.base.element.Tag
import pt.isel.SHORT.html.element.Div

@Page("/page2")
fun Tag.page2() = Div { Text("Hello from Page 2.") }
