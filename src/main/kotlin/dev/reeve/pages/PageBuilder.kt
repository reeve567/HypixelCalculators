package dev.reeve.pages

import kotlinx.css.CSSBuilder
import kotlinx.html.*
import kotlinx.html.dom.createHTMLDocument
import org.w3c.dom.Document

class PageBuilder {
	private val html = createHTMLDocument()
	private val components = mutableListOf<HtmlComponent>()

	fun addComponent(component: HtmlComponent): PageBuilder {
		components.add(component)
		return this
	}

	fun build(): Document {
		html.html {
			head {
				style {
					components.forEach {
						it.css(this)
					}
				}
			}
			body {
				components.forEach {
					it.html(this)
				}
			}
		}

		return html.finalize()
	}
}