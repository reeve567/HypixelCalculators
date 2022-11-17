package dev.reeve.api

data class Items(
	var lastSaved: Long = 0,
	var success: Boolean = false,
	var items: List<Item> = listOf()
)