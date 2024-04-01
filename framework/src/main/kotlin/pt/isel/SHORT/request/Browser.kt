package pt.isel.SHORT.request

import pt.isel.SHORT.BrowserNotSupportedException

interface Browser {
    val product: String
    val version: Version
    companion object {
        enum class Format {
            DESKTOP,
            MOBILE
        }

        data class Version(val major: Int, val minor: Int, val patch: Int) {
            companion object {

                fun fromString(version: String): Version {
                    val versionParts = version.split(".").map { it.toInt() }
                    return Version(
                        versionParts.getOrZero(0),
                        versionParts.getOrZero(1),
                        versionParts.getOrZero(2)
                    )
                }
            }

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

private fun List<Int>.getOrZero(index: Int): Int {
    return if (index < this.size) this[index] else 0
}

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
