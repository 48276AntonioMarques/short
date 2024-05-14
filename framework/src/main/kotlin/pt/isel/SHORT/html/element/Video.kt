package pt.isel.SHORT.html.element

import pt.isel.SHORT.html.Attribute
import pt.isel.SHORT.html.Tag

 /**
 * Represents the HTML <video> tag.
 * Description: Embeds a media player which supports video playback into the document. You can also use video for audio content, but the audio element may provide a more appropriate user experience.
 */
fun Tag.Video(attributes: List<Attribute> = emptyList(), content: HtmlReceiver? = null): Tag = apply {
    appendChild(prototype("video", attributes, content))
}
