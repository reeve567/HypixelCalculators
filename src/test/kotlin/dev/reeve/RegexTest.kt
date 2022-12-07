package dev.reeve

import dev.reeve.scraping.RegexLiterals
import java.io.File
import kotlin.reflect.KProperty0
import kotlin.test.Test

class RegexTest {
	private val regexOutputFolder = File("./regexOutput")
	private val minionsPage = javaClass.getResource("/minionsPage.html")?.readText() ?: error("Couldn't load resource")

	init {
		regexOutputFolder.mkdirs()
	}

	@Test
	fun testLinkRegex() {
		println(RegexLiterals.minionLinkRegex)
		writeToFile(RegexLiterals::minionLinkRegex)


		val group = RegexLiterals.minionLinkRegex.find("""<a href="/wiki/Flower_Minion" title="Flower Minion">Flower</a>""")?.groups?.get("name")

		assert(group?.value == "Flower")
	}

	@Test
	fun testIdRegex() {
		println(RegexLiterals.minionIdRegex)
		writeToFile(RegexLiterals::minionIdRegex)

		val group = RegexLiterals.minionIdRegex.find(minionsPage)?.groups?.get("id")

		println(group?.value)
		assert(group?.value == "GHAST")
	}

	@Test
	fun testDropsRegex() {
		println(RegexLiterals.minionDropsRegex)
		writeToFile(RegexLiterals::minionDropsRegex)

		val matches = RegexLiterals.minionDropsRegex.findAll(minionsPage).map { it.groups }

		for (match in matches) {
			println(match)
		}
	}

	private fun writeToFile(property: KProperty0<Regex>) {
		val file = File(regexOutputFolder, "${property.name}.txt")
		file.writeText(property.get().toString())
	}
}