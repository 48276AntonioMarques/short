import Pages.page1
import Pages.page2
import diff.markTextDiff2
import pt.isel.SHORT.Application
import pt.isel.SHORT.PageFactory
import pt.isel.SHORT.aggregatePages
import pt.isel.SHORT.getPages
import pt.isel.SHORT.html.base.element.Tag
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
        val pages = getPages(listOf("Pages.Page1Kt"))
        assert(pages.size == 1)
    }

    @Test
    fun `get pages with two inputs`() {
        val pages = getPages(listOf("Pages.Page1Kt", "Pages.Page2Kt"))
        assert(pages.size == 2)
    }

    @Test
    fun `aggregate pages with no input`() {
        val application = Application(emptyArray())
        val htmlPage = aggregatePages(application, emptyList())
        val expectedPath = "expected/PageAggregatorTests/NoInput.html"
        val expectedResult = ClassLoader.getSystemResource(expectedPath).readText().normalize()
        val actualResult = htmlPage.toHtml().normalize()
        println(markTextDiff2(actualResult, expectedResult))
        assert(actualResult == expectedResult)
    }

    @Test
    fun `aggregate pages with one input`() {
        val pages = listOf(Tag::page1.javaMethod as PageFactory)

        val application = Application(emptyArray())
        val htmlPage = aggregatePages(application, pages)
        val expectedPath = "expected/PageAggregatorTests/OneInput.html"
        val expectedResult = ClassLoader.getSystemResource(expectedPath).readText().normalize()
        val actualResult = htmlPage.toHtml().normalize()
        // println(actualResult)
        println(markTextDiff2(actualResult, expectedResult))
        assert(actualResult == expectedResult)
    }

    @Test
    fun `aggregate pages with two inputs`() {
        val pages = listOf(Tag::page1.javaMethod as PageFactory, Tag::page2.javaMethod as PageFactory)

        val application = Application(emptyArray())
        val htmlPage = aggregatePages(application, pages)
        val expectedPath = "expected/PageAggregatorTests/TwoInputs.html"
        val expectedResult = ClassLoader.getSystemResource(expectedPath).readText().normalize()
        val actualResult = htmlPage.toHtml().normalize()
        println(markTextDiff2(actualResult, expectedResult))
        assert(actualResult == expectedResult)
    }
}
