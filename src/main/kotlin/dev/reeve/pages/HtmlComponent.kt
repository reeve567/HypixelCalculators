package dev.reeve.pages

import kotlinx.css.CSSBuilder
import kotlinx.html.BODY
import kotlinx.html.STYLE

interface HtmlComponent {
	fun html(body: BODY)
	fun css(style: STYLE)
}