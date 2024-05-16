import Pages.page1
import Pages.page2
import Pages.page3
import pt.isel.SHORT.html.Body
import pt.isel.SHORT.html.Html
import pt.isel.SHORT.html.Text
import pt.isel.SHORT.html.element.Div
import kotlin.test.Test

class PagesTests {

    private fun String.normalize() = this.replace("\r", "")

    @Test
    fun `generate page without extending tag`() {
        val page = Html {
            Body {
                Div {
                    Text("Hello World!")
                }
            }
        }
        val expected = "<body><div>Hello World!</div></body>"
        println(page.innerHtml().normalize())
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate text only page`() {
        val page = Html {
            Body {
                Text("Hello World!")
            }
        }
        val expected = "<body>Hello World!</body>"
        println(page.innerHtml().normalize())
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate page using non extension function`() {
        val html = Html {}
        val page = { root: Html ->
            root.Body {
                Div {
                    Text("Hello World!")
                }
            }
        }
        val expected = "<body><div>Hello World!</div></body>"
        val result = page(html).innerHtml().normalize()
        println(result)
        assert(result == expected)
    }

    @Test
    fun `generate page1`() {
        val html = Html {}
        val page = html.Body().page1()
        val expected = "<body></body><div>Hello from Page 1.</div>"
        println(page.innerHtml().normalize())
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate page1 with lambda`() {
        val page = Html {
            Body {
                page1()
            }
        }
        val expected = "<body><div>Hello from Page 1.</div></body>"
        println(page.innerHtml().normalize())
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate page2`() {
        val html = Html {}
        val page = html.Body().page2()
        val expected = "<body></body><div>Hello from Page 2.</div>"
        println(page.innerHtml().normalize())
        assert(page.innerHtml().normalize() == expected)
    }

    @Test
    fun `generate page3`() {
        val html = Html {}
        val page = html.Body().page3()
        val expected = "<body></body><div>Hello from Page 3.</div>"
        println(page.innerHtml().normalize())
        assert(page.innerHtml().normalize() == expected)
    }
}
