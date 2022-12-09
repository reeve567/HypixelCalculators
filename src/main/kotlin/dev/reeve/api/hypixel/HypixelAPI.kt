package dev.reeve.api.hypixel

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request

object HypixelAPI {
	private lateinit var apiKey: String
	private val gson = GsonBuilder().setPrettyPrinting().create()
	private val client = OkHttpClient()
	private const val baseUrl = "https://api.hypixel.net/"
	
	fun setApiKey(key: String) {
		apiKey = key
	}
	
	val items: ItemsResult by lazy {
		val request = Request.Builder().url(baseUrl + "resources/skyblock/items").get().build()
		client.newCall(request).execute().use {
			if (it.code != 200) return@use
			
			return@lazy gson.fromJson(it.body!!.string(), ItemsResult::class.java)
		}
		return@lazy ItemsResult()
	}

	fun fetchPlayerProfiles(id: String): ProfilesResult? {
		val request = Request.Builder().url(baseUrl + "skyblock/profiles?uuid=$id").get().header("API-Key", apiKey).build()
		client.newCall(request).execute().use {
			if (it.code != 200) {
				println("Error: ${it.code}")
				println(it.body?.string())
				return@use
			}
			return gson.fromJson(it.body!!.string(), ProfilesResult::class.java)
		}

		return null
	}

	fun fetchBazaar(): BazaarResult? {
		val request = Request.Builder().url(baseUrl + "skyblock/bazaar").get().build()
		client.newCall(request).execute().use {
			if (it.code != 200) return@use
			return gson.fromJson(it.body!!.string(), BazaarResult::class.java)
		}

		return null
	}

	// TODO: add election api to reflect prices

}