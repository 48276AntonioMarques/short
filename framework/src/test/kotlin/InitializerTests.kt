import pt.isel.SHORT.Application
import pt.isel.SHORT.runSHORT
import kotlin.test.Test

class InitializerTests {

    @Test
    fun `basic initialization`() {
        println(System.getProperty("java.version"))
        class WebApp : Application()

        val args = emptyArray<String>()
        runSHORT<WebApp>(args)
    }
}
