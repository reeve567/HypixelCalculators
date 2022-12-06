package dev.reeve

import dev.reeve.scraping.RegexLiterals
import java.io.File
import kotlin.reflect.KProperty0
import kotlin.test.Test

class RegexTest {
	private val regexOutputFolder = File("./regexOutput")

	init {
		regexOutputFolder.mkdirs()
	}

	@Test
	fun testLinkRegex() {
		println(RegexLiterals.minionLinkRegex)
		writeToFile(RegexLiterals::minionLinkRegex)
	}

	@Test
	fun testIdRegex() {
		println(RegexLiterals.minionIdRegex)
		writeToFile(RegexLiterals::minionIdRegex)
	}

	@Test
	fun testDropsRegex() {
		println(RegexLiterals.minionDropsRegex)
		writeToFile(RegexLiterals::minionDropsRegex)
	}

	private fun writeToFile(property: KProperty0<Regex>) {
		val file = File(regexOutputFolder, "${property.name}.txt")
		file.writeText(property.get().toString())
	}
}