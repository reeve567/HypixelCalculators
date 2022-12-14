package dev.reeve.scraping

class RegexBuilder(block: RegexBuilder.() -> Unit = {}) {
	private val regex = StringBuilder()
	val nonQuoteSelector = getNonSelector("\"").oneOrMore()
	val whiteSpaceSelector = getNonCapturingGroup("\\s*")

	init {
		block()
	}

	fun add(string: String) {
		regex.append(string)
	}

	fun addWhiteSpaceSelector() {
		add(whiteSpaceSelector)
	}

	fun getNamedGroup(name: String, string: String): String {
		 return "(?<${name}>${string})"
	}

	fun addNamedGroup(name: String, string: String) {
		add(getNamedGroup(name, string))
	}

	fun getNonCapturingGroup(string: String): String {
		return "(?:${string})"
	}
	fun addNonCapturingGroup(string: String) {
		add(getNonCapturingGroup(string))
	}

	fun getNonSelector(notSelected: String): String {
		return "[^${notSelected}]"
	}

	fun addNotQuoteSelector() {
		add(nonQuoteSelector)
	}

	fun String.zeroOrMore(): String {
		return "$this*"
	}

	fun String.oneOrMore(): String {
		return "$this+"
	}

	fun build(): String {
		return regex.toString()
	}
}