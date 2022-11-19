package dev.reeve.api.influx

object InfluxAPI {
	private lateinit var apiKey: String
	private const val baseUrl = "https://influx.reeve.dev/"

	fun setApiKey(key: String) {
		apiKey = key
	}
}