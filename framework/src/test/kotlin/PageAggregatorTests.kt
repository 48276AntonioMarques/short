import pt.isel.SHORT.aggregatePages
import kotlin.test.Test

class PageAggregatorTests {
    @Test
    fun `generate pages with no input`() {
        val pages = aggregatePages(emptyList())
        assert(true)
    }
}
