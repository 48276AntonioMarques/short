package pt.isel.SHORT.config

import pt.isel.SHORT.request.Chrome
import pt.isel.SHORT.request.ChromeAndroid
import pt.isel.SHORT.request.Edge
import pt.isel.SHORT.request.Firefox
import pt.isel.SHORT.request.FirefoxAndroid
import pt.isel.SHORT.request.Opera
import pt.isel.SHORT.request.OperaAndroid
import pt.isel.SHORT.request.Safari
import pt.isel.SHORT.request.SafariIos
import pt.isel.SHORT.request.SamsungInternet
import pt.isel.SHORT.request.UserAgent
import pt.isel.SHORT.request.WebViewAndroid

/**
 * Minimum browser requirements for the template client router and components.
 */
val templateUserAgentRequirements = UserAgent.Requirements(
    Chrome(26, 0, 0),
    Edge(13, 0, 0),
    Firefox(22, 0, 0),
    Opera(15, 0, 0),
    Safari(8, 0, 0),
    ChromeAndroid(26, 0, 0),
    FirefoxAndroid(22, 0, 0),
    OperaAndroid(14, 0, 0),
    SafariIos(8, 0, 0),
    SamsungInternet(1, 5, 0),
    WebViewAndroid(1, 0, 0)
)
