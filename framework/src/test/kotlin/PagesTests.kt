import Pages.page1
import Pages.page2
import Pages.page3
import pt.isel.SHORT.html.Html
import pt.isel.SHORT.html.element.Div
import pt.isel.SHORT.html.element.Text
import kotlin.test.Test

class PagesTests {

    private fun String.normalize() = this.replace("\r", "")

    @Test
    fun `generate page without extending tag`() {
        val page = Html {
            Div {
                Text("Hello World!")
            }
        }
        val expected = "<div>Hello World!</div>"
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate text only page`() {
        val page = Html {
            Text("Hello World!")
        }
        val expected = "Hello World!"
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate page using non extension function`() {
        val html = Html {}
        val page = { root: Html ->
            root.Div {
                Text("Hello World!")
            }
        }
        val expected = "<div>Hello World!</div>"
        assert(page(html).innerHtml().normalize() == expected)
    }

    @Test
    fun `generate page1`() {
        val html = Html {}
        val page = html.page1()
        val expected = "<div>Hello from Page 1.</div>"
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate page1 with lambda`() {
        val page = Html {
            page1()
        }
        val expected = "<div>Hello from Page 1.</div>"
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate page2`() {
        val html = Html {}
        val page = html.page2()
        val expected = "<div>Hello from Page 2.</div>"
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate page3`() {
        val html = Html {}
        val page = html.page3()
        val expected = "<div>Hello from Page 3.</div>"
        assert(page.innerHtml().normalize() == expected)
    }
}
