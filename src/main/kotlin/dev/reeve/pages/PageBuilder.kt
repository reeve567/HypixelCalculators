package dev.reeve.pages

import kotlinx.css.CSSBuilder
import kotlinx.html.*
import kotlinx.html.dom.createHTMLDocument
import org.w3c.dom.Document

class PageBuilder {
	private val html = createHTMLDocument()
	private var navigationBar = false
	private var header: Header? = null

	fun addNavigationBar() {
		navigationBar = true
	}

	fun addHeader(header: Header) {
		this.header = header
	}

	fun build(): Document {
		html.html {
			head {
				style {
					header?.css(this)
				}
			}
			body {
				header?.html(this)
			}
		}

		return html.finalize()
	}
}