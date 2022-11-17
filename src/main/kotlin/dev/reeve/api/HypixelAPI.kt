package dev.reeve.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.UUID

object HypixelAPI {
	private lateinit var apiKey: String
	private val gson = GsonBuilder().setPrettyPrinting().create()
	private val client = OkHttpClient()
	private const val baseUrl = "https://api.hypixel.net/"
	
	fun setApiKey(key: String) {
		apiKey = key
	}
	
	val items: Items by lazy {
		val request = Request.Builder().url(baseUrl + "resources/skyblock/items").get().build()
		client.newCall(request).execute().use {
			if (it.code != 200) return@use
			
			return@lazy gson.fromJson(it.body!!.string(), Items::class.java)
		}
		return@lazy Items()
	}

	fun fetchPlayerProfiles(id: String): Profiles {
		val request = Request.Builder().url(baseUrl + "skyblock/profiles?uuid=$id").get().build()
		client.newCall(request).execute().use {
			if (it.code != 200) return@use
			return gson.fromJson(it.body!!.string(), Profiles::class.java)
		}
		return Profiles()
	}

}