package pt.isel.SHORT.request

import pt.isel.SHORT.BrowserNotSupportedException
import pt.isel.SHORT.request.Browser.Companion.Version as BrowserVersion

/**
 * Represents the Header User Agent from the HTTP request
 */
object UserAgent {

    /**
     * Represents all the browsers that are supported by a certain feature
     * @param browsers the browsers that are supported
     * Each browser is represented by a [Browser] object
     * @see Browser
     */
    class Requirements(vararg browsers: Browser) {
        private val browsers = browsers.toList()

        // User Agent Example
        // "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36"
        fun verifyUserAgentCompatibility(userAgent: String?, criteria: Criteria): Boolean {
            // if userAgent is null, blank or browsers are not supported return false

            if (userAgent.isNullOrBlank()) return false
            if (browsers.isEmpty()) return false

            // Extract browser format
            val format = when {
                userAgent.contains("Android") -> Browser.Companion.Format.MOBILE
                userAgent.contains("Mobile") -> Browser.Companion.Format.MOBILE
                userAgent.contains("iPhone") -> Browser.Companion.Format.MOBILE
                userAgent.contains("iPad") -> Browser.Companion.Format.MOBILE
                else -> Browser.Companion.Format.DESKTOP
            }

            // Extract browser and version from userAgent
            // User Agent structure is: "Browser/version (comment)"
            val productVersionPairs = userAgent.split(" ").filter { it.contains("/") }
            val browsersFound = productVersionPairs.mapNotNull { productVersion ->
                val (product, versionString) = productVersion.split("/")
                val version = BrowserVersion.fromString(versionString)
                try {
                    product.toBrowser(version, format)
                } catch (_: BrowserNotSupportedException) {
                    null
                }
            }

            // Check if the browser version is compatible with the requirements
            val comparisons = browsersFound.map { browser ->
                browsers.find { b -> b.product == browser.product }?.let { b ->
                    when (criteria) {
                        Criteria.LESS_THAN -> browser.version < b.version
                        Criteria.LESS_THAN_OR_EQUAL -> browser.version <= b.version
                        Criteria.EQUAL -> browser.version == b.version
                        Criteria.GREATER_THAN_OR_EQUAL -> browser.version >= b.version
                        Criteria.GREATER_THAN -> browser.version > b.version
                    }
                } ?: false
            }

            // This is arbitrary
            // return comparisons.any { it } // is compatible if at least one browser is compatible
            return comparisons.all { it } // is compatible if all browsers are compatible
        }
    }

    /**
     * Represents the criteria wanted when comparing the browser versions.
     * For instance, if the criteria is [LESS_THAN] the browser version must be less than the required version.
     */
    enum class Criteria {
        LESS_THAN,
        LESS_THAN_OR_EQUAL,
        EQUAL,
        GREATER_THAN_OR_EQUAL,
        GREATER_THAN
    }
}
