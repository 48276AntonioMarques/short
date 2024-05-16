package pt.isel.SHORT.request

import pt.isel.SHORT.BrowserNotSupportedException
import pt.isel.SHORT.ClassManager
import pt.isel.SHORT.request.Browser.Companion.Format as Format
import pt.isel.SHORT.request.Browser.Companion.Version as Version

/**
 * Represents a browser.
 * All implementations of this interface MUST have a constructor with the following signature:
 * `constructor(major: Int, minor: Int, patch: Int)`
 * @property product the browser product name. Must comply with Pascal Casing.
 * @property format the browser format.
 * @property version the browser version.
 */
interface Browser {
    val product: String
    val format: Format
    val version: Version
    companion object {

        /**
         * Represents the Format of the browser.
         * @property DESKTOP the browser is a desktop browser.
         * @property MOBILE the browser is a mobile browser.
         */
        enum class Format {
            DESKTOP,
            MOBILE
        }

        /**
         * Represents the version of the browser.
         * The versioning is done in the following format: major.minor.patch
         * Some browsers may not follow exactly this format.
         * @property major the major version.
         * @property minor the minor version.
         * @property patch the patch version.
         */
        data class Version(val major: Int, val minor: Int, val patch: Int) {
            companion object {

                /**
                 * Creates a Version from a string.
                 * Any missing part of the version will be considered as 0.
                 * @param version the version string.
                 * @return the Version object.
                 */
                fun fromString(version: String): Version {
                    val versionParts = version.split(".").map { it.toInt() }
                    return Version(
                        versionParts.getOrZero(0),
                        versionParts.getOrZero(1),
                        versionParts.getOrZero(2)
                    )
                }
            }

            /**
             * Compares two versions.
             * @param other the other version.
             * @return a negative integer, zero, or a positive integer as this version is less than, equal to, or greater than the specified version.
             */
            operator fun compareTo(other: Version): Int {
                return when {
                    major != other.major -> major - other.major
                    minor != other.minor -> minor - other.minor
                    else -> patch - other.patch
                }
            }
        }

        /**
         * All the supported browsers at the beginning of runtime.
         */
        private val browserClasses: List<Class<Browser>> = getAllBrowsers()
        val browsers: List<Pair<String, Class<Browser>>> =
            getFormatBrowsers(browserClasses, *Format.entries.toTypedArray())
        val desktopBrowsers: List<Pair<String, Class<Browser>>> = getFormatBrowsers(browserClasses, Format.DESKTOP)
        val mobileBrowsers: List<Pair<String, Class<Browser>>> = getFormatBrowsers(browserClasses, Format.MOBILE)

        @Suppress("UNCHECKED_CAST")
        private fun getAllBrowsers(): List<Class<Browser>> {
            // Get all classes
            val classNames = ClassManager.searchClasses("")
            val classes = classNames.map { className ->
                try {
                    Class.forName(className)
                } catch (e: Exception) {
                    null
                }
            }.filterNotNull()
            // Filter the ones that implement Browser
            // This cast will always be safe because we are filtering the classes that implement Browser
            return classes.filter { Browser::class.java.isAssignableFrom(it) }.map { it as Class<Browser> }
        }

        /**
         * Creates a list with browser's names and classes that have the specified format.
         * @param browsers the list containing the class of each browser.
         * @param formats the formats to filter.
         * @return the list with pairs containing the browser's names and classes that have the specified format.
         */
        private fun getFormatBrowsers(
            browsers: List<Class<Browser>>,
            vararg formats: Format
        ): List<Pair<String, Class<Browser>>> {
            val formatsList = formats.toList()
            return browsers.mapNotNull { clazz ->
                val browserConstructor = clazz.getConstructor(Int::class.java, Int::class.java, Int::class.java)
                val browser = browserConstructor.newInstance(0, 0, 0) as Browser
                if (formatsList.contains(browser.format)) Pair(browser.product, clazz) else null
            }
        }
    }
}

/**
 * This is a helper function to get a value from a list or return 0 if the index is out of bounds.
 */
private fun List<Int>.getOrZero(index: Int): Int {
    return if (index < this.size) this[index] else 0
}

/**
 * Creates a Browser from a string.
 */
fun String.toBrowser(version: Version, format: Format): Browser {
    val browsers = when (format) {
        Format.DESKTOP -> Browser.desktopBrowsers
        Format.MOBILE -> Browser.mobileBrowsers
    }
    val clazz = browsers.find { (product, _) -> product == this }?.second
    clazz ?: throw BrowserNotSupportedException("Browser not supported: $this")

    val constructor = clazz.getConstructor(Int::class.java, Int::class.java, Int::class.java)
    return constructor.newInstance(version.major, version.minor, version.patch) as Browser
}

class Chrome(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Chrome"
    override val format = Browser.Companion.Format.DESKTOP
    override val version = Browser.Companion.Version(major, minor, patch)
}

class Edge(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Edge"
    override val format = Browser.Companion.Format.DESKTOP
    override val version = Browser.Companion.Version(major, minor, patch)
}

class Firefox(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Firefox"
    override val format = Browser.Companion.Format.DESKTOP
    override val version = Browser.Companion.Version(major, minor, patch)
}

class Opera(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Chrome"
    override val format = Browser.Companion.Format.DESKTOP
    override val version = Browser.Companion.Version(major, minor, patch)
}

class Safari(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Safari"
    override val format = Browser.Companion.Format.DESKTOP
    override val version = Browser.Companion.Version(major, minor, patch)
}

class ChromeAndroid(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Chrome"
    override val format = Browser.Companion.Format.MOBILE
    override val version = Browser.Companion.Version(major, minor, patch)
}

class FirefoxAndroid(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Firefox"
    override val format = Browser.Companion.Format.MOBILE
    override val version = Browser.Companion.Version(major, minor, patch)
}

class OperaAndroid(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Chrome"
    override val format = Browser.Companion.Format.MOBILE
    override val version = Browser.Companion.Version(major, minor, patch)
}

class SafariIos(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Safari"
    override val format = Browser.Companion.Format.MOBILE
    override val version = Browser.Companion.Version(major, minor, patch)
}

class SamsungInternet(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "SamsungBrowser"
    override val format = Browser.Companion.Format.MOBILE
    override val version = Browser.Companion.Version(major, minor, patch)
}

class WebViewAndroid(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "WebView"
    override val format = Browser.Companion.Format.MOBILE
    override val version = Browser.Companion.Version(major, minor, patch)
}
