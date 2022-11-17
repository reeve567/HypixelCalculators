package dev.reeve.pages

import kotlinx.css.*
import kotlinx.html.*

class Header(private val content: String, private val subtitle: String? = null) : HtmlComponent {
	override fun html(body: BODY) = with(body) {
		h1(classes = "page-header") {
			+content
		}
		if (subtitle != null) {
			h2(classes = "page-subtitle") {
				+subtitle
			}
		}
	}

	override fun css(style: STYLE): Unit = with(style) {
		ruleSet {
			"h1.page-header" {
				fontSize = 50.px
				width = 100.pct
				textAlign = TextAlign.center
			}
			if (subtitle != null)
				"h2.page-subtitle" {
					fontSize = 30.px
					width = 100.pct
					textAlign = TextAlign.center
				}
		}
	}
}