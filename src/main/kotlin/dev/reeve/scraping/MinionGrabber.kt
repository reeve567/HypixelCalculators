package dev.reeve.scraping

import okhttp3.OkHttpClient
import okhttp3.Request

class MinionGrabber {
	private val baseUrl = "https://hypixel-skyblock.fandom.com"
	private val urlPath = "/wiki/Minions"
	private val client = OkHttpClient()



	fun getMinions() {
		val request = Request.Builder()
			.url(baseUrl + urlPath)
			.build()

		val response = client.newCall(request).execute()
		val body = response.body?.string()

		if (body != null) {
			val minions = RegexLiterals.minionLinkRegex.findAll(body)
			for (minion in minions) {
				val name = minion.groups["name"]?.value ?: continue // couldn't find name

				getMinionData(name)
			}
		}
	}

	private fun getMinionData(name: String) {
		val url = "$baseUrl/wiki/${name}_Minion"

		val request = Request.Builder()
			.url(url)
			.build()

		val response = client.newCall(request).execute()
		val body = response.body?.string()

	}
}