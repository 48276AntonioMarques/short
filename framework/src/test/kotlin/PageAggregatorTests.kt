import PageAggregatorSources.page1
import PageAggregatorSources.page2
import pt.isel.SHORT.PageFactory
import pt.isel.SHORT.aggregatePages
import pt.isel.SHORT.getPages
import pt.isel.SHORT.html.HtmlTag
import kotlin.reflect.jvm.javaMethod
import kotlin.test.Test

class PageAggregatorTests {

    private fun String.normalize() = this.replace("\r", "")

    @Test
    fun `get pages with no input`() {
        val pages = getPages(emptyList())
        assert(pages.isEmpty())
    }

    @Test
    fun `get pages with one input`() {
        val pages = getPages(listOf("PageAggregatorSources.OnePageKt"))
        assert(pages.size == 1)
    }

    @Test
    fun `get pages with two inputs`() {
        val pages = getPages(listOf("PageAggregatorSources.TwoPagesKt"))
        assert(pages.size == 2)
    }

    @Test
    fun `aggregate pages with no input`() {
        val htmlPage = aggregatePages(emptyList())
        val expectedPath = "expected/PageAggregatorTests/NoInput.html"
        val expectedResult = ClassLoader.getSystemResource(expectedPath).readText().normalize()
        val actualResult = htmlPage.toHtml().normalize()
        println(actualResult)
        assert(actualResult == expectedResult)
    }

    @Test
    fun `aggregate pages with one input`() {
        val pages = listOf(HtmlTag::page1.javaMethod as PageFactory)

        val htmlPage = aggregatePages(pages)
        val expectedPath = "expected/PageAggregatorTests/OneInput.html"
        val expectedResult = ClassLoader.getSystemResource(expectedPath).readText().normalize()
        val actualResult = htmlPage.toHtml().normalize()
        println(actualResult)
        assert(actualResult == expectedResult)
    }

    @Test
    fun `aggregate pages with two inputs`() {
        val pages = listOf(HtmlTag::page1.javaMethod as PageFactory, HtmlTag::page2.javaMethod as PageFactory)

        val htmlPage = aggregatePages(pages)
        val expectedPath = "expected/PageAggregatorTests/TwoInputs.html"
        val expectedResult = ClassLoader.getSystemResource(expectedPath).readText().normalize()
        val actualResult = htmlPage.toHtml().normalize()
        println(actualResult)
        assert(actualResult == expectedResult)
    }
}
