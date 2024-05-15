package pt.isel.SHORT.request

import pt.isel.SHORT.BrowserNotSupportedException
import pt.isel.SHORT.NoRequirementException
import pt.isel.SHORT.request.Browser.Companion.Format as BrowserFormat
import pt.isel.SHORT.request.Browser.Companion.Version as BrowserVersion

/**
 * Represents the Header User Agent from the HTTP request
 */
class UserAgent(private val header: String) {
    // User Agent Example
    // "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36"

    private val format: BrowserFormat = when {
        header.contains("Android") -> Browser.Companion.Format.MOBILE
        header.contains("Mobile") -> Browser.Companion.Format.MOBILE
        header.contains("iPhone") -> Browser.Companion.Format.MOBILE
        header.contains("iPad") -> Browser.Companion.Format.MOBILE
        else -> Browser.Companion.Format.DESKTOP
    }

    // Extract browser and version from userAgent
    // User Agent structure is: "Browser/version (comment)"
    private val targetBrowsers: List<Browser> = getTargets(header)

    private fun getTargets(header: String): List<Browser> =
        header
            .split(" ")
            .filter { it.contains("/") }
            .mapNotNull { productVersion ->
                val (product, versionString) = productVersion.split("/")
                val version = BrowserVersion.fromString(versionString)
                try {
                    product.toBrowser(version, format)
                } catch (_: BrowserNotSupportedException) {
                    null
                }
            }

    /**
     * Compares target browsers from the User Agent with the provided browser.
     */
    operator fun compareTo(browser: Browser): Int {
        val target = targetBrowsers.find { target -> target.product == browser.product }
        target ?: throw NoRequirementException("User agent does not target that platform.")
        return target.version.compareTo(browser.version)
    }
}
