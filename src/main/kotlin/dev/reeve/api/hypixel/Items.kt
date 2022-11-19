package dev.reeve.api.hypixel

data class Items(
	var lastSaved: Long = 0,
	var success: Boolean = false,
	var items: List<Item> = listOf()
)