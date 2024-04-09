import pt.isel.SHORT.Application
import pt.isel.SHORT.runSHORT
import kotlin.test.Test

class InitializerTests {

    @Test
    fun `basic initialization`() {
        // This test is failing because the test is not running with the right java version
        // TODO: Change the java version to the right one (17+)
        println(System.getProperty("java.version"))
        class WebApp(arguments: Array<String>) : Application(arguments)

        val args = emptyArray<String>()
        runSHORT<WebApp>(args)
    }
}
