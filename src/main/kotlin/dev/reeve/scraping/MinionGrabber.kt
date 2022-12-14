package dev.reeve.scraping

import dev.reeve.api.hypixel.Minion
import okhttp3.OkHttpClient
import okhttp3.Request

class MinionGrabber {
	private val baseUrl = "https://hypixel-skyblock.fandom.com"
	private val urlPath = "/wiki/Minions"
	private val client = OkHttpClient()

	fun getMinions(): List<Minion> {
		val request = Request.Builder()
			.url(baseUrl + urlPath)
			.build()

		val response = client.newCall(request).execute()
		val body = response.body?.string()

		if (body != null) {
			val minions = RegexLiterals.minionLinkRegex.findAll(body)
			val minionList = mutableListOf<Minion>()
			for (minion in minions) {
				val name = minion.groups["name"]?.value ?: continue // couldn't find name

				minionList.add(getMinionData(name) ?: error("Couldn't get minion data for $name, url: $baseUrl/wiki/${name}_Minion"))
			}
		}

		return emptyList()
	}

	private fun getMinionData(name: String): Minion? {
		val url = "$baseUrl/wiki/${name}_Minion"

		val request = Request.Builder()
			.url(url)
			.build()

		val response = client.newCall(request).execute()
		val body = response.body?.string()

		val matches = RegexLiterals.minionDropsRegex.findAll(body ?: return null)

		TODO("Until the drops regex doesn't cause a stack overflow, it won't pass the line above")

		val drops = mutableListOf<Minion.MinionDrop>()

		for (match in matches) {
			val dropName = match.groups["name"]?.value ?: continue
			val dropChance = match.groups["chance"]?.value ?: continue
			val dropAmount = match.groups["amount"]?.value ?: continue

			if (dropAmount.contains("in")) {

			} else if (dropAmount.contains("%")) {

			}
		}

		return null
	}
}