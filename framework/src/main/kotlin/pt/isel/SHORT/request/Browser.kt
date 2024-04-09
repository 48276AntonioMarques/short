package pt.isel.SHORT.request

import pt.isel.SHORT.BrowserNotSupportedException

/**
 * Represents a browser.
 * @property product the browser product name.
 * @property version the browser version.
 */
interface Browser {
    val product: String
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
fun String.toBrowser(version: Browser.Companion.Version, format: Browser.Companion.Format): Browser {
    return when (this) {
        "Chrome" -> {
            if (format == Browser.Companion.Format.MOBILE) {
                ChromeAndroid(version.major, version.minor, version.patch)
            } else {
                Chrome(version.major, version.minor, version.patch)
            }
        }
        "Edge" -> Edge(version.major, version.minor, version.patch)
        "Firefox" -> {
            if (format == Browser.Companion.Format.MOBILE) {
                FirefoxAndroid(version.major, version.minor, version.patch)
            } else {
                Firefox(version.major, version.minor, version.patch)
            }
        }
        "Opera" -> {
            if (format == Browser.Companion.Format.MOBILE) {
                OperaAndroid(version.major, version.minor, version.patch)
            } else {
                Opera(version.major, version.minor, version.patch)
            }
        }
        "Safari" -> {
            if (format == Browser.Companion.Format.MOBILE) {
                SafariIos(version.major, version.minor, version.patch)
            } else {
                Safari(version.major, version.minor, version.patch)
            }
        }
        "SamsungBrowser" -> SamsungInternet(version.major, version.minor, version.patch)
        "WebView" -> WebViewAndroid(version.major, version.minor, version.patch)
        else -> throw BrowserNotSupportedException("Browser $this is not supported")
    }
}

class Chrome(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Chrome"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class Edge(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Edge"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class Firefox(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Firefox"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class Opera(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Chrome"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class Safari(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Safari"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class ChromeAndroid(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Chrome"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class FirefoxAndroid(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Firefox"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class OperaAndroid(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Chrome"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class SafariIos(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "Safari"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class SamsungInternet(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "SamsungBrowser"
    override val version = Browser.Companion.Version(major, minor, patch)
}

class WebViewAndroid(major: Int, minor: Int, patch: Int) : Browser {
    override val product = "WebView"
    override val version = Browser.Companion.Version(major, minor, patch)
}
