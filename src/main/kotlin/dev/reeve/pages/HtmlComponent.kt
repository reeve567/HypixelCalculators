package dev.reeve.pages

import kotlinx.css.CSSBuilder
import kotlinx.html.BODY
import kotlinx.html.STYLE

abstract class HtmlComponent {
	abstract fun html(body: BODY)
	abstract fun css(style: STYLE)
}